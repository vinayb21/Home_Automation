package com.example.vinay.smarthomes;

import android.content.Intent;
import android.os.AsyncTask;
import android.speech.RecognizerIntent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_SPEECH_RESULT = 0;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.btnCommand);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    startVoiceCommand();
                }
                catch(Exception e)
                {
                    Snackbar.make(v, "Voice Command not recognised", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        Button btn1 = (Button) findViewById(R.id.controls);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    // Start RoomsActivity.class
                    Intent myIntent = new Intent(MainActivity.this, RoomsActivity.class);
                    startActivity(myIntent);
                }
                catch(Exception e)
                {
                    Snackbar.make(v, "Rooms Page is unavailable", Snackbar.LENGTH_LONG).show();
                }
            }
        });
        //new getURLData().execute("http://192.168.1.4:3010/");
    }

    private void startVoiceCommand() {
        Log.d(TAG, "Starting Voice intent...");
        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Please give the command");
        startActivityForResult(i, REQ_SPEECH_RESULT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /*super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_SPEECH_RESULT && resultCode == RESULT_OK) {
            ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            //ed.setText(result.get(0));
        }*/

        super.onActivityResult(requestCode, resultCode, data);
        EditText ed = (EditText) findViewById(R.id.editText);
        // Check the Request code
        try
        {
            if (requestCode ==  REQ_SPEECH_RESULT) {
                Log.d(TAG, "Request speech result..");
                ArrayList<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                String command = results.get(0);
                String ans="",device="";
                String[] words = command.trim().split("\\s+");
                Arrays.sort(words);
                if(Arrays.binarySearch(words, "switch")>=0 ||Arrays.binarySearch(words, "turn")>=0)
                {
                    if(Arrays.binarySearch(words, "on")>=0)
                    {
                        ans = "Turn on the ";
                        if(Arrays.binarySearch(words, "light")>=0) {

                            device = "light";
                            String path = IP.ip;
                            if(Arrays.binarySearch(words, "hall")>=0)
                            {
                                path = path+"on?room=1&&deviceId=1";
                                new DeviceController().execute(path);
                            }
                            else if(Arrays.binarySearch(words, "bedroom")>=0)
                            {
                                path = path+"on?room=2&&deviceId=1";
                                new DeviceController().execute(path);
                            }
                            else if(Arrays.binarySearch(words, "kitchen")>=0)
                            {
                                path = path+"on?room=3&&deviceId=1";
                                new DeviceController().execute(path);
                            }
                            else if(Arrays.binarySearch(words, "diningroom")>=0 || Arrays.binarySearch(words, "dining")>=0 && Arrays.binarySearch(words, "room")>=0)
                            {
                                path = path+"on?room=4&&deviceId=1";
                                new DeviceController().execute(path);
                            }
                            else if(Arrays.binarySearch(words, "guestroom")>=0 || Arrays.binarySearch(words, "guest")>=0 && Arrays.binarySearch(words, "room")>=0)
                            {
                                path = path+"on?room=5&&deviceId=1";
                                new DeviceController().execute(path);
                            }
                            else if(Arrays.binarySearch(words, "bathroom")>=0)
                            {
                                path = path+"on?room=6&&deviceId=1";
                                new DeviceController().execute(path);
                            }
                        }
                        else if(Arrays.binarySearch(words, "fan")>=0) {
                            device = "fan";
                            String path = IP.ip;
                            if(Arrays.binarySearch(words, "hall")>=0)
                            {
                                path = path+"on?room=1&&deviceId=2";
                                new DeviceController().execute(path);
                            }
                            else if(Arrays.binarySearch(words, "bedroom")>=0)
                            {
                                path = path+"on?room=2&&deviceId=2";
                                new DeviceController().execute(path);
                            }
                            else if(Arrays.binarySearch(words, "kitchen")>=0)
                            {
                                path = path+"on?room=3&&deviceId=2";
                                new DeviceController().execute(path);
                            }
                            else if(Arrays.binarySearch(words, "diningroom")>=0 || Arrays.binarySearch(words, "dining")>=0 && Arrays.binarySearch(words, "room")>=0)
                            {
                                path = path+"on?room=4&&deviceId=2";
                                new DeviceController().execute(path);
                            }
                            else if(Arrays.binarySearch(words, "guestroom")>=0 || Arrays.binarySearch(words, "guest")>=0 && Arrays.binarySearch(words, "room")>=0)
                            {
                                path = path+"on?room=5&&deviceId=2";
                                new DeviceController().execute(path);
                            }
                        }
                        else if(Arrays.binarySearch(words, "AC")>=0 || Arrays.binarySearch(words, "ac")>=0 || Arrays.binarySearch(words, "air conditioner")>=0)
                            device = "air-conditioner";
                    }
                    else if(Arrays.binarySearch(words, "off")>=0)
                    {
                        ans = "Turn off the ";
                        if(Arrays.binarySearch(words, "light")>=0) {
                            device = "light";
                            String path = IP.ip;
                            if(Arrays.binarySearch(words, "hall")>=0)
                            {
                                path = path+"off?room=1&&deviceId=1";
                                new DeviceController().execute(path);
                            }
                            else if(Arrays.binarySearch(words, "bedroom")>=0)
                            {
                                path = path+"off?room=2&&deviceId=1";
                                new DeviceController().execute(path);
                            }
                            else if(Arrays.binarySearch(words, "kitchen")>=0)
                            {
                                path = path+"off?room=3&&deviceId=1";
                                new DeviceController().execute(path);
                            }
                            else if(Arrays.binarySearch(words, "diningroom")>=0 || Arrays.binarySearch(words, "dining")>=0 && Arrays.binarySearch(words, "room")>=0)
                            {
                                path = path+"off?room=4&&deviceId=1";
                                new DeviceController().execute(path);
                            }
                            else if(Arrays.binarySearch(words, "guestroom")>=0 || Arrays.binarySearch(words, "guest")>=0 && Arrays.binarySearch(words, "room")>=0)
                            {
                                path = path+"off?room=5&&deviceId=1";
                                new DeviceController().execute(path);
                            }
                            else if(Arrays.binarySearch(words, "bathroom")>=0)
                            {
                                path = path+"off?room=6&&deviceId=1";
                                new DeviceController().execute(path);
                            }
                        }
                        else if(Arrays.binarySearch(words, "fan")>=0)
                        {
                            device = "fan";
                            String path = IP.ip;
                            if(Arrays.binarySearch(words, "hall")>=0)
                            {
                                path = path+"off?room=1&&deviceId=2";
                                new DeviceController().execute(path);
                            }
                            else if(Arrays.binarySearch(words, "bedroom")>=0)
                            {
                                path = path+"off?room=2&&deviceId=2";
                                new DeviceController().execute(path);
                            }
                            else if(Arrays.binarySearch(words, "kitchen")>=0)
                            {
                                path = path+"off?room=3&&deviceId=2";
                                new DeviceController().execute(path);
                            }
                            else if(Arrays.binarySearch(words, "diningroom")>=0 || Arrays.binarySearch(words, "dining")>=0 && Arrays.binarySearch(words, "room")>=0)
                            {
                                path = path+"off?room=4&&deviceId=2";
                                new DeviceController().execute(path);
                            }
                            else if(Arrays.binarySearch(words, "guestroom")>=0 || Arrays.binarySearch(words, "guest")>=0 && Arrays.binarySearch(words, "room")>=0)
                            {
                                path = path+"off?room=5&&deviceId=2";
                                new DeviceController().execute(path);
                            }
                        }
                        /*else if(Arrays.binarySearch(words, "AC")>=0 || Arrays.binarySearch(words, "ac")>=0 || Arrays.binarySearch(words, "air conditioner")>=0)
                            device = "air-conditioner";*/
                    }
                }
                ans = ans + device;
                if(ans.equals(""))
                    ans = "Invalid command. Please try again!";
                // Set the text to EditText field for testing and debugging purposes
                ed.setText(ans, TextView.BufferType.EDITABLE);
                Log.d(TAG, "Current command [" + command + "]");
                // Now we send commands to the IoT device
            }
        }
        catch(Exception e)
        {
            Log.e(TAG, "Null pointer Exception");
        }

    }
}
