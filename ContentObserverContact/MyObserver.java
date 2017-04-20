package com.contentobserver;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

class MyObserver extends ContentObserver {

    Context context;

    public /*static final*/ String ACCOUNT_TYPE /*=*/ /*"com.android.account.youraccounttype"*/ /*AccountManager.getAccounts()[0]*/;

    //    public static final String WHERE_MODIFIED = "( " + ContactsContract.RawContacts.DELETED + "=1 ) ";
//    public static final String WHERE_MODIFIED = "( " + ContactsContract.RawContacts.DIRTY + "=1 ) ";

    public static final String WHERE_MODIFIED = "( " + ContactsContract.RawContacts.DELETED + "=1 OR " + ContactsContract.RawContacts.DIRTY + "=1 ) ";

//    ContactsContract.RawContacts.DIRTY + "=1 ) AND " + ContactsContract.RawContacts.ACCOUNT_TYPE + " = '" + ACCOUNT_TYPE + "'";


    public MyObserver(Handler handler, Context context) {
        super(handler);
        this.context = context;
    }

    @Override
    public void onChange(boolean selfChange) {

        this.onChange(selfChange, null);

        Log.e("", "~~~~~~" + selfChange);

        // Override this method to listen to any changes
    }

    @Override
    public void onChange(boolean selfChange, Uri uri) {

        Log.e("selfChange", "- " + selfChange);
        Log.e("uri", "- " + uri);

//        Cursor cursor = context.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, ContactsContract.Contacts.CONTACT_LAST_UPDATED_TIMESTAMP + " Desc");
//
//        if (cursor.moveToNext()) {
//
//            String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
//            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
//
//            Log.w("Contact ID", id);
//            Log.w("Person Name", name);
//        }

//        ACCOUNT_TYPE = /*"com.android.account.youraccounttype"*/ AccountManager.getAccounts()[0].type;

        ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();

        Uri rawUri = ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter(ContactsContract.CALLER_IS_SYNCADAPTER, "true").build();


        Cursor cursor = context.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI,
                null,
                WHERE_MODIFIED,
                null,
                null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {

            String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            String rowid = cursor.getString(cursor.getColumnIndex(ContactsContract.RawContacts._ID));

            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

            Log.w("Contact ID", id);
            Log.w("Contact Row ID", rowid);
            Log.w("Person Name", name);

            int deletedRawContacts = context.getContentResolver().delete(ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter(ContactsContract.CALLER_IS_SYNCADAPTER, "true").build(), ContactsContract.RawContacts._ID + " = ? AND " + ContactsContract.RawContacts.DELETED + " = 1", new String[]{rowid});

            if (deletedRawContacts > 0) {
                Log.d(TAG, "Delete OK");
            } else {
                Log.d(TAG, "Nothing to delete");
            }

            ContentValues contentValues = new ContentValues();
            contentValues.put(ContactsContract.RawContacts.DIRTY, "0");

            int editedRawContacts = context.getContentResolver().update(ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter(ContactsContract.CALLER_IS_SYNCADAPTER, "true").build(), contentValues, ContactsContract.RawContacts._ID + " = ? AND " + ContactsContract.RawContacts.DIRTY + " = 1", new String[]{rowid});

            if (editedRawContacts > 0) {
                Log.d(TAG, "edit OK");
            } else {
                Log.d(TAG, "Nothing to edit");
            }

            cursor.moveToNext();
        }
    }
}