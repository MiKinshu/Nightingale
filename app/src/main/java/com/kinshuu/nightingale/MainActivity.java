package com.kinshuu.nightingale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent= new Intent(MainActivity.this,com.kinshuu.nightingale.MapsActivity.class);
        startActivity(intent);
    }
}
