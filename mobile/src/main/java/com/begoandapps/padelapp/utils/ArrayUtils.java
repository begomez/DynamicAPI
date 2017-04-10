package com.begoandapps.padelapp.utils;

/**
 * Created by bernatgomez on 10/4/17.
 */

public abstract class ArrayUtils {

    public static boolean valueInRange(int pos, int max) {
        return pos >= 0 && pos < max;
    }
}
