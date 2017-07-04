package com.begoandapps.padelapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.begoandapps.padelapp.R;

/**
 * Created by bernatgomez on 4/7/17.
 */

public class SearchResultDetailFragment extends BaseFragment {

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
}
