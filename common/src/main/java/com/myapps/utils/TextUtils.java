package com.myapps.utils;

/**
 * Created by bernatgomez on 20/3/17.
 */

public abstract class TextUtils {

    /**
     *
     * @param text
     * @return
     */
    public static String trim(String text) {
        return new StringBuffer(text).toString().trim();
    }
}
