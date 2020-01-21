package com.hummbletech.room_database_adder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Indoor tracker Manager");

        TextView heading = findViewById(R.id.title);
        heading.setText("Welcome Manager! Customize your Indoor Navigation!");

        
    }
}
