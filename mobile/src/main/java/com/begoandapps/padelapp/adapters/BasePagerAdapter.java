package com.begoandapps.padelapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by bernatgomez on 13/3/17.
 */

public abstract class BasePagerAdapter extends FragmentPagerAdapter {

    public BasePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public abstract Fragment getItem(int position);

    @Override
    public abstract int getCount();
}
