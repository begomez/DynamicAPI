package com.myapps.utils;

/**
 * Created by bernatgomez on 20/3/17.
 */

public abstract class TextUtils {

    public static boolean isValidString(String str) {
        return str != null && !str.trim().equals("");
    }

    /**
     *
     * @param text
     * @return
     */
    public static String trim(String text) {
        return new StringBuffer(text).toString().trim();
    }
}
