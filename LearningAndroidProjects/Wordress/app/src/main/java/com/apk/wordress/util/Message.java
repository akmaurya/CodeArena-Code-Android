package com.apk.wordress.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by sanjay.bind1 on 10/1/2017.
 */

public class Message {

    public static void message(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
