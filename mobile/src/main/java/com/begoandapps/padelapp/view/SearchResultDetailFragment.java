package com.begoandapps.padelapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.adapters.SearchDetailPagerAdapter;
import com.begoandapps.padelapp.view.interfaces.IDetail;
import com.myapps.utils.LoggerUtils;

import butterknife.BindView;

/**
 * Created by bernatgomez on 4/7/17.
 */

public class SearchResultDetailFragment extends BaseFragment {

    private static final String TAG = SearchResultDetailFragment.class.getSimpleName();

    @BindView(R.id.item_result_pager)
    protected ViewPager pager;

    private SearchDetailPagerAdapter adapter;


    public static SearchResultDetailFragment newInstance() {
        return new SearchResultDetailFragment();
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// LIFE CYCLE
/////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.layoutId = R.layout.fragment_search_result_detail;
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// ARCHITECTURE
/////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void configViews() {
        super.configViews();

        this.configPager();
    }

    private void configPager() {
        this.adapter = new SearchDetailPagerAdapter(this.getFragmentManager(), this.getContext());

        this.pager.setAdapter(this.adapter);

        this.pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                LoggerUtils.logMsg(TAG, "selected: " + position);

                ((IDetail) adapter.getItem(position)).pageWithFocus();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
