package com.apk.wordress;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import gr.net.maroulis.library.EasySplashScreen;

public class WelcomeScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        EasySplashScreen config = new EasySplashScreen(WelcomeScreen.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(2000)
                .withBackgroundColor(Color.parseColor("#074E72"))
                .withLogo(R.drawable.splash_screen)
                .withFooterText("Copyright 2017");


        //Set text color
        config.getFooterTextView().setTextColor(Color.WHITE);

        View view = config.create();
        setContentView(view);
    }
}
