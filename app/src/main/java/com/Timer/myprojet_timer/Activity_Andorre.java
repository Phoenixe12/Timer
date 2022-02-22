package com.Timer.myprojet_timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Activity_Andorre extends AppCompatActivity {
    TextView currentTime,calculatedTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_andorre);
        currentTime =findViewById(R.id.current_time);
        calculatedTime = findViewById(R.id.calculated_time);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss a");
        String currenTimee = simpleDateFormat.format(calendar.getTime());
        currentTime.setText(currenTimee);
        try {
            Date date = simpleDateFormat.parse(currenTimee);
            calendar.setTime(date);
            calendar.add(Calendar.MINUTE,0);
            String result = simpleDateFormat.format(calendar.getTime());
            calculatedTime.setText(result);
        }catch (Exception e){
            currentTime.setText(R.string.app_name);
        }
    }
}