package com.myapps.padelapp.navigation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.myapps.padelapp.view.BaseFragment;

/**
 * Created by bernatgomez on 7/3/17.
 */

public class NavigationUtis {

    /**
     *
     * @param mgr
     * @param frag
     * @param contentFrame
     */
    public static void launchFragment(FragmentManager mgr, BaseFragment frag, int contentFrame) {
        FragmentTransaction trans = mgr.beginTransaction();

        trans.replace(contentFrame, frag);

        trans.addToBackStack(frag.getComponentIdentifier());

        trans.commit();

        mgr.executePendingTransactions();
    }

    /**
     *
     * @param cntxt
     * @param c
     */
    public static void navigateToActivity(Context cntxt, Class c) {
        Intent i = new Intent(cntxt, c);

        cntxt.startActivity(i);
    }
}