package com.begoandapps.padelapp.utils;

import android.util.Log;

/**
 * Created by bernatgomez on 6/3/17.
 */

public abstract class AndroidLoggerUtils {

    /**
     *
     * @param tag
     * @param msg
     */
    public static void logMsg(String tag, String msg) {
        Log.d(tag, msg);
    }

    public static void logError(String tag, String msg, Exception e) {
        Log.e(tag, msg);
    }
}
