package com.developer.external;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.read).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//		Read External Permission Needed
                onReadMethod();
            }
        });

        findViewById(R.id.write).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//		Write External Permission Needed
                onCreateMethod();
            }
        });
    }

    public void onReadMethod() {

        File file = new File(Environment.getExternalStorageDirectory(), "CSV/contacts.csv");

        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }

            br.close();

            Toast.makeText(this, "Data:\n" + text, Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onCreateMethod() {

        String sBody = "aaa,bbb,ccc\naaa,bbb,ccc\naaa,bbb,ccc\naaa,bbb,ccc";

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "CSV");

            Log.d("Location", Environment.getExternalStorageDirectory() + "");

            if (!root.exists()) {
                root.mkdirs();
            }

            File gpxfile = new File(root, "contacts.csv");
            FileWriter writer = new FileWriter(gpxfile);

            writer.append(sBody);
            writer.flush();
            writer.close();

            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
