package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class countdown extends AppCompatActivity {

    private int seconds = 86500;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);

        runTimer();

    }

    public void runTimer(){
        final TextView timeView = (TextView) findViewById(R.id.timeView);

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds % 3600;
                int minutes = (seconds % 3600) / 60;
                int days = seconds % 86400;

                String time = String.format("%02d:%02d:%02d",days,hours,minutes);
                timeView.setText(time);

                if(days == 0 && hours == 0 && minutes == 0){
                    running = false;
                }

                if(running){
                    seconds--;
                }

                handler.postDelayed(this,1000);
            }
        });
    }

}