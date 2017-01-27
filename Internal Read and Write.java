package com.vardhaman.csvtest;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        findViewById(R.id.read).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onReadMethod();
            }
        });

        findViewById(R.id.write).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreateMethod();
            }
        });
    }

    public void onReadMethod() {

        File file = new File(Environment.getExternalStorageDirectory(), "CSV/contacts.csv");

        String text = new String();

        try {
            ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
            File directory = contextWrapper.getDir("CSV", Context.MODE_PRIVATE);
            File filelocation = new File(directory, "contacts.csv");

            FileInputStream fis = new FileInputStream(filelocation);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine;

            while ((strLine = br.readLine()) != null) {
                text = text + strLine;
                text += "\n";
            }

            in.close();

            Toast.makeText(this, "Data:\n" + text, Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onCreateMethod() {

        String sBody = "aaa,bbb,ccc\naaa,bbb,ccc\naaa,bbb,ccc\naaa,bbb,ddd";

        try {
            ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
            File directory = contextWrapper.getDir("CSV", Context.MODE_PRIVATE);
            File filelocation = new File(directory, "contacts.csv");

            FileOutputStream fos = new FileOutputStream(filelocation);
            fos.write(sBody.getBytes());
            fos.close();

            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
