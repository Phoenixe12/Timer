package com.Timer.myprojet_timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity_Amenia extends AppCompatActivity {
    TextView currentTime,calculatedTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amenia);
        currentTime =findViewById(R.id.current_time);
        calculatedTime = findViewById(R.id.calculated_time);

        java.util.Calendar calendar = java.util.Calendar.getInstance();
        java.text.SimpleDateFormat simpleDateFormat =new java.text.SimpleDateFormat("hh:mm:ss a");
        String currenTimee = simpleDateFormat.format(calendar.getTime());
        currentTime.setText(currenTimee);
        try {
            java.util.Date date = simpleDateFormat.parse(currenTimee);
            calendar.setTime(date);
            calendar.add(java.util.Calendar.MINUTE,-240);
            String result = simpleDateFormat.format(calendar.getTime());
            calculatedTime.setText(result);
        }catch (Exception e){
            currentTime.setText(R.string.app_name);
        }

    }
}