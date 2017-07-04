package com.begoandapps.padelapp.adapters;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.view.SearchDetailCommentsFragment;
import com.begoandapps.padelapp.view.SearchDetailInfoFragment;


/**
 * Created by bernatgomez on 4/7/17.
 */
public class SearchDetailPagerAdapter extends BasePagerAdapter {

    private static final int NUM_ITEMS = 2;

    private static final int POSITION_INFO = 0;
    private static final int POSITION_COMMENTS = 1;

    private Context cntxt;


    /**
     *
     * @param fm
     * @param cntxt
     */
    public SearchDetailPagerAdapter(FragmentManager fm, Context cntxt) {
        super(fm);

        this.cntxt = cntxt;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case POSITION_INFO:
                return SearchDetailInfoFragment.newInstance();
            case POSITION_COMMENTS:
                return SearchDetailCommentsFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        super.getPageTitle(position);

        switch (position) {
            case POSITION_INFO:
                return this.cntxt.getResources().getString(R.string.search_detail_info_title);
            case POSITION_COMMENTS:
                return this.cntxt.getResources().getString(R.string.search_detail_comments_title);
            default:
                return "";
        }

    }
}
