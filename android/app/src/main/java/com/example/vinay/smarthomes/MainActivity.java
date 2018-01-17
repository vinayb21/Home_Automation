package com.example.vinay.smarthomes;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
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
                // Set the text to EditText field for testing and debugging purposes
                ed.setText(command, TextView.BufferType.EDITABLE);
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
