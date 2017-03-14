package com.myapps.padelapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.myapps.padelapp.interfaces.INavigable;
import com.myapps.padelapp.view.TutorialFragment;

/**
 * Created by bernatgomez on 13/3/17.
 */

public class TutorialAdapter extends BasePagerAdapter {

    private static final String TAG = TutorialAdapter.class.getSimpleName();

    private static final int NUM_SLIDES = 5;

    private INavigable navCallback;


    public TutorialAdapter(FragmentManager fm, INavigable navCallback) {
        super(fm);

        this.navCallback = navCallback;
    }

    @Override
    public Fragment getItem(int position) {
        TutorialFragment frag = TutorialFragment.newInstance(position);

        frag.setNavCallback(this.navCallback);

        return frag;
    }

    @Override
    public int getCount() {
        return NUM_SLIDES;
    }
}
