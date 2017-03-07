package com.myapps.padelapp.navigation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by bernatgomez on 7/3/17.
 */

public class NavigationUtis {
    public static void navigateToActivity(Context cntxt, Class c) {
        Intent i = new Intent(cntxt, c);

        cntxt.startActivity(i);
    }
}
