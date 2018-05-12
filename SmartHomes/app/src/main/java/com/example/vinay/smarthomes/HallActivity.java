package com.example.vinay.smarthomes;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by vinay on 15-01-2018.
 */

public class HallActivity extends AppCompatActivity
{
    String[] devices = {"Light", "Fan", "A.C."};

    String TAG = "HallActivity";

    // Array of booleans to store toggle button status
    public boolean[] status = {false,false,false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall);

        /** Restore from the previous state if exists */
        if(savedInstanceState!=null){
            status = savedInstanceState.getBooleanArray("status");
        }

        //new HallDeviceState().execute();

        ListView deviceList = (ListView) findViewById(R.id.deviceListHall);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View item, int position, long id) {

                ListView lView = (ListView) listView;

                SimpleAdapter adapter = (SimpleAdapter) lView.getAdapter();

                HashMap<String,Object> hm = (HashMap) adapter.getItem(position);

                /** The clicked Item in the ListView */
                RelativeLayout rLayout = (RelativeLayout) item;

                /** Getting the toggle button corresponding to the clicked item */
                ToggleButton tgl = (ToggleButton) rLayout.getChildAt(1);

                String strStatus = "";
                if(tgl.isChecked())
                {
                    int roomId = 1;
                    String path = IP.ip;
                    path = path+"off?room="+roomId+"&&deviceId="+(position+1);
                    new DeviceController().execute(path);
                    Log.e(TAG, path);
                    tgl.setChecked(false);
                    strStatus = "Off";
                    status[position]=false;
                    //path = IP.ip;
                    //path = path+"changeDeviceState?roomID="+roomId+"&&deviceType="+(position+1)+"&&state=0";
                    //new DeviceController().execute(path);
                }
                else
                {
                    int roomId = 1;
                    if(position==1)
                    {
                        tgl.setChecked(true);
                        strStatus = "On";
                        status[position] = true;
                        Intent newActivity = new Intent(HallActivity.this, FanControlActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("room","1");
                        newActivity.putExtras(bundle);
                        startActivity(newActivity);
                    }
                    else
                    {
                        String path = IP.ip;
                        path = path + "on?room=" + roomId + "&&deviceId=" + (position + 1);
                        new DeviceController().execute(path);
                        Log.e(TAG, path);
                        tgl.setChecked(true);
                        strStatus = "On";
                        status[position] = true;
                        path = IP.ip;
                        path = path+"deviceStateChange?roomID="+roomId+"&&deviceType="+(position+1)+"&&state=1";
                        new DeviceController().execute(path);
                    }
                }
                Toast.makeText(getBaseContext(), (String) hm.get("txt") + " : " + strStatus, Toast.LENGTH_SHORT).show();
            }
        };

        deviceList.setOnItemClickListener(itemClickListener);

        // Each row in the list stores device name and its status
        List<HashMap<String,Object>> aList = new ArrayList<HashMap<String,Object>>();

        for(int i=0;i<devices.length;i++){
            HashMap<String, Object> hm = new HashMap<String,Object>();
            hm.put("txt", devices[i]);
            hm.put("stat",status[i]);
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = {"txt","stat"};

        // Ids of views in listview_layout
        int[] to = { R.id.device_item, R.id.tgl_status};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.activity_devicelist, from, to);

        deviceList.setAdapter(adapter);
    }

    private class HallDeviceState extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
























































                        Toast.makeText(HallActivity.this,"Json Data is downloading",Toast.LENGTH_LONG).show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = IP.ip+"hallDevices";
            String jsonStr = sh.makeServiceCall(url);

            //Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    //Log.e(TAG, jsonStr)
                    //Log.e(TAG, "JSONObject: "+ String.valueOf(jsonObj));
                    JSONArray jsonarray = new JSONArray(jsonStr);
                    String[] s = new String[3];
                    for(int i=0;i<jsonarray.length();i++)
                    {
                        JSONObject object= jsonarray.getJSONObject(i);
                        s[i] = object.getString("status");
                    }

                    for(int i=0;i<3;i++)
                    {
                        if(s[i].equals("0"))
                            status[i] = false;
                        else
                            status[i] = true;
                    }


                    for(int i=0;i<3;i++)
                        Log.e(TAG, "Status["+i+"]:  "+s[i]);
                    /*
                    // Getting JSON Array node
                    JSONArray contacts = jsonObj.getJSONArray("contacts");

                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);
                        String id = c.getString("id");
                        String name = c.getString("name");
                        String email = c.getString("email");
                        String address = c.getString("address");
                        String gender = c.getString("gender");

                        // Phone node is JSON Object
                        JSONObject phone = c.getJSONObject("phone");
                        String mobile = phone.getString("mobile");
                        String home = phone.getString("home");
                        String office = phone.getString("office");

                        // tmp hash map for single contact
                        HashMap<String, String> contact = new HashMap<>();

                        // adding each child node to HashMap key => value
                        contact.put("id", id);
                        contact.put("name", name);
                        contact.put("email", email);
                        contact.put("mobile", mobile);

                        // adding contact to contact list
                        contactList.add(contact);
                    }*/
                } catch (Exception e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    /*runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });*/

                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            /*ListAdapter adapter = new SimpleAdapter(MainActivity.this, contactList,
                    R.layout.list_item, new String[]{ "email","mobile"},
                    new int[]{R.id.email, R.id.mobile});
            lv.setAdapter(adapter);*/
        }
    }

    /** Saving the current state of the activity
     * for configuration changes [ Portrait <=> Landscape ]
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBooleanArray("status", status);
    }

}