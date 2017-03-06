package com.myapps.padelapp.utils;

import android.util.Log;

/**
 * Created by bernatgomez on 6/3/17.
 */

public abstract class AndroidLoggerUtils {
    public static void logMsg(String tag, String msg) {
        Log.d(tag, msg);
    }
}
