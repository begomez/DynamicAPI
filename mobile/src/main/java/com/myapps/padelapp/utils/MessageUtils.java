package com.myapps.padelapp.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by bernatgomez on 20/3/17.
 */

public abstract class MessageUtils {

    /**
     *
     * @param cntxt
     * @param msg
     */
    public static void showToast(Context cntxt, String msg) {
        Toast.makeText(cntxt, msg, Toast.LENGTH_LONG).show();
    }
}
