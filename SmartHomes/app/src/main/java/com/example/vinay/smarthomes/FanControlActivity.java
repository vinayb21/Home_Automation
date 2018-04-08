package com.example.vinay.smarthomes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by vinay on 08-04-2018.
 */

public class FanControlActivity extends AppCompatActivity {
    String TAG = "FanControlActivity";
    String room;

    //String lName = intent.getStringExtra("lastName");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fancontrol);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle!=null)
        {
            room = bundle.getString("room");
        }

        Button btn1 = (Button) findViewById(R.id.speed_1);
        Button btn2 = (Button) findViewById(R.id.speed_2);
        Button btn3 = (Button) findViewById(R.id.speed_3);
        Button btn4 = (Button) findViewById(R.id.speed_4);
        Button btn5 = (Button) findViewById(R.id.speed_5);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path = IP.ip;
                path = path + "fan?room="+room+"&&deviceId=2&&speed=1";
                new DeviceController().execute(path);
                Log.e(TAG, path);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path = IP.ip;
                path = path + "fan?room="+room+"&&deviceId=2&&speed=2";
                new DeviceController().execute(path);
                Log.e(TAG, path);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path = IP.ip;
                path = path + "fan?room="+room+"&&deviceId=2&&speed=3";
                new DeviceController().execute(path);
                Log.e(TAG, path);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path = IP.ip;
                path = path + "fan?room="+room+"&&deviceId=2&&speed=4";
                new DeviceController().execute(path);
                Log.e(TAG, path);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path = IP.ip;
                path = path + "fan?room="+room+"&&deviceId=2&&speed=5";
                new DeviceController().execute(path);
                Log.e(TAG, path);
            }
        });
    }
}
