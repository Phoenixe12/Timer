package com.Timer.myprojet_timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_event);

        TextView textView = findViewById(R.id.detailtext);

        String descriptions = "Descriptions not set";

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            descriptions = extras.getString("descriptions");
        }

        textView.setText(descriptions);
    }
}