package com.example.wholesalemanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_SCREEN_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this,
                        TakeATourActivity.class);
                //Intent is used to switch from one activity to another. 

                startActivity(i);
                //invoke the SecondActivity. 

                finish();
                //the current activity will get finished. 
            }
        }, SPLASH_SCREEN_TIME_OUT);
    }
}