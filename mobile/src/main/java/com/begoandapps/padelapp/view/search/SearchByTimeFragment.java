package com.begoandapps.padelapp.view.search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TimePicker;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.view.core.BaseFragment;

import butterknife.BindView;

/**
 * Created by bernatgomez on 11/4/17.
 */

public class SearchByTimeFragment extends BaseFragment {

    @BindView(R.id.search_by_time_clock)
    protected TimePicker clock;

///////////////////////////////////////////////////////////////////////////////////////
//
///////////////////////////////////////////////////////////////////////////////////////
    public static SearchByTimeFragment newInstance() {
        SearchByTimeFragment f = new SearchByTimeFragment();

        return f;
    }

///////////////////////////////////////////////////////////////////////////////////////
//
///////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.layoutId = R.layout.fragment_search_by_time;
    }

///////////////////////////////////////////////////////////////////////////////////////
//
///////////////////////////////////////////////////////////////////////////////////////


    @Override
    public void configViews() {
        super.configViews();

        this.configClock();
    }

    private void configClock() {

    }
}
