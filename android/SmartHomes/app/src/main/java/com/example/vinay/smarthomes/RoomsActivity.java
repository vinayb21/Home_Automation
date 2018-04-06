package com.example.vinay.smarthomes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by vinay on 11-01-2018.
 */

public class RoomsActivity extends AppCompatActivity {

    String[] rooms = {"Hall", "Bedroom", "Kitchen", "Dining Room", "Guestroom", "Bathroom"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, rooms);

        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch(position)
                {
                    case 0:
                        Intent newActivity = new Intent(RoomsActivity.this, HallActivity.class);
                        startActivity(newActivity);
                        break;
                    case 1:
                        Intent newActivity1 = new Intent(RoomsActivity.this, BedroomActivity.class);
                        startActivity(newActivity1);
                        break;
                    case 2:
                        Intent newActivity2 = new Intent(RoomsActivity.this, KitchenActivity.class);
                        startActivity(newActivity2);
                        break;
                    case 3:
                        Intent newActivity3 = new Intent(RoomsActivity.this, DiningroomActivity.class);
                        startActivity(newActivity3);
                        break;
                    case 4:
                        Intent newActivity4 = new Intent(RoomsActivity.this, GuestroomActivity.class);
                        startActivity(newActivity4);
                        break;
                    case 5:
                        Intent newActivity5 = new Intent(RoomsActivity.this, BathroomActivity.class);
                        startActivity(newActivity5);
                        break;
                }
            }

            @SuppressWarnings("unused")
            public void onClick(View v){
            };

        });

    }
}
