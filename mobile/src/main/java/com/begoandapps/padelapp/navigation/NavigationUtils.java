package com.begoandapps.padelapp.navigation;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.begoandapps.padelapp.view.core.BaseFragment;

/**
 * Created by bernatgomez on 7/3/17.
 */

public class NavigationUtils {

    /**
     *
     * @param mgr
     * @param frag
     * @param contentFrame
     */
    public static void launchFragment(FragmentManager mgr, BaseFragment frag, int contentFrame) {
        NavigationUtils.launchFragment(mgr, frag, contentFrame, false);
    }

    /**
     *
     * @param mgr
     * @param frag
     * @param contentFrame
     */
    public static void launchFragment(FragmentManager mgr, BaseFragment frag, int contentFrame, boolean addToBackStack) {
        FragmentTransaction trans = mgr.beginTransaction();

        trans.replace(contentFrame, frag);

        if (addToBackStack) {
            trans.addToBackStack(frag.getComponentIdentifier());
        }

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

        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        cntxt.startActivity(i);
    }
}
