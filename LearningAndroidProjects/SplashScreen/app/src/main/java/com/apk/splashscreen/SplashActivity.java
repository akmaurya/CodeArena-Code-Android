package com.apk.splashscreen;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(SplashActivity.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(5000)
                .withBackgroundColor(Color.parseColor("#074E72"))
                .withLogo(R.drawable.splash_screen)
                .withFooterText("Copyright 2017");


        //Set text color
        config.getFooterTextView().setTextColor(Color.WHITE);

        View view = config.create();
        setContentView(view);
    }
}
