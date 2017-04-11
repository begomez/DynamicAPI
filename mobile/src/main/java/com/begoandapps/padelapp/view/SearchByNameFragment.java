package com.begoandapps.padelapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.begoandapps.padelapp.R;

/**
 * Created by bernatgomez on 11/4/17.
 */

public class SearchByNameFragment extends BaseFragment {

////////////////////////////////////////////////////////////////////////////////////
// LIFE CYCLE
////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.layoutId = R.layout.fragment_search_by_name;
    }
}
