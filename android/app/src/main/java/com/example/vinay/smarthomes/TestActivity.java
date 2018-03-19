package com.example.vinay.smarthomes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by vinay on 22-02-2018.
 */

public class TestActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
