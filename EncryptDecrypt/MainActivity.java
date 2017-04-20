package com.encdec;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private byte[] key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        key = new byte[0];

        try {
            key = "mykey".getBytes("UTF-8");

            Log.d("Path", ">" + Environment.getExternalStorageDirectory());
            Log.d("Path1", ">" + Environment.getRootDirectory());
            Log.d("Path2", ">" + Environment.getExternalStoragePublicDirectory("Download"));
            Log.d("Path3", ">" + System.getenv("EXTERNAL_STORAGE"));
            Log.d("Path4", ">" + getFilesDir().getCanonicalPath());
            Log.d("Path5", ">" + getFilesDir().getPath());
            Log.d("Path6", ">" + getFilesDir().getAbsolutePath());

            Log.d("key", ">" + key);

            checkAndRequestPermissions();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_enc) {

//            /storage/13E6-1D1B

            try {

                new AESFiles().encrypt(new File(Environment.getExternalStoragePublicDirectory("Download") + "/Tests/secure.txt"), new File(Environment.getExternalStoragePublicDirectory("Download") + "/Tests/secure.txt.aes"), key);

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return true;

        } else if (id == R.id.action_dec) {

            try {

                new AESFiles().decrypt(new File(Environment.getExternalStoragePublicDirectory("Download") + "/Tests/secure.txt.aes"), new File(Environment.getExternalStoragePublicDirectory("Download") + "/Tests/secure.txt.1"), key);

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void checkAndRequestPermissions() {

        String[] permissions = new String[]{
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };

        List<String> listPermissionsNeeded = new ArrayList<>();

        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(permission);
            }
        }

        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

        switch (requestCode) {
            case 1:

                if (grantResults.length > 0) {

//                    boolean cameraPermission = grantResults[0] == PackageManager.PERMISSION_GRANTED;
//                    boolean writeExternalStorage = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    int i;

                    for (i = 0; i < grantResults.length; i++) {
                        if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(MainActivity.this, "Permission Denied", Toast.LENGTH_LONG).show();
                            break;
                        }
                    }

                    if (grantResults.length == i) {
                        Toast.makeText(MainActivity.this, "Permission Granted", Toast.LENGTH_LONG).show();
                    }
                }

                break;
        }
    }
}