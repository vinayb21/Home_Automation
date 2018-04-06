package com.example.vinay.smarthomes;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by vinay on 20-03-2018.
 */

public class DeviceController extends AsyncTask<String, String, String> {

    private static final String TAG = "DeviceController";

    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String line = "";
        String finalJSON = "";
        try {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();


            InputStream stream = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();

            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            finalJSON = buffer.toString();
            if (finalJSON != null)
                Log.e(TAG, finalJSON);
            Log.e(TAG, connection.getResponseCode() + "");
            return finalJSON;
            //return buffer.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (connection != null) {
                Log.e(TAG, "Connection established");
                //Log.e(TAG, finalJSON.toString());
                connection.disconnect();
            } else {
                Log.e(TAG, "Connection not established");
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
