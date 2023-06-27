package com.arvind.learn.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Current State";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "It is Created");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "It is Started");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "It is Resumed");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "It is Stoped");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "It is Restarted");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "It is Destroyed");
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

    @Override
    protected void onResume() {
        super.onResume();
    }
}
