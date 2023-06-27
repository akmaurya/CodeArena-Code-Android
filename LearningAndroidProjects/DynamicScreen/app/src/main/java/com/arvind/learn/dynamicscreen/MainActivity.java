package com.arvind.learn.dynamicscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Status";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"Created");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"Started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"Stoped");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"Paused");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"Restarted");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"Destroyed");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "It is on save instance state");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "It is on restore instance state");
    }
}
