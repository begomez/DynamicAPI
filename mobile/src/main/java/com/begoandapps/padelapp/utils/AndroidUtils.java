package com.begoandapps.padelapp.utils;

import android.content.Context;

/**
 * Created by bernatgomez on 13/3/17.
 */

public abstract class AndroidUtils {

    /**
     *
     * @param cntxt
     * @return
     */
    public static String getPackageIdentifier(Context cntxt) {
        return cntxt.getPackageName();
    }
}
