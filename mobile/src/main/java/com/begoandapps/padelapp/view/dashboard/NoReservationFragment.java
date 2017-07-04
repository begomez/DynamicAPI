package com.begoandapps.padelapp.view.dashboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.view.core.BaseFragment;

/**
 * Created by bernatgomez on 11/4/17.
 */

public class NoReservationFragment extends BaseFragment {


//////////////////////////////////////////////////////////////////////////////////
// CONSTRUCTOR
//////////////////////////////////////////////////////////////////////////////////
    public static NoReservationFragment newInstance() {
        NoReservationFragment f = new NoReservationFragment();

        return f;
    }

//////////////////////////////////////////////////////////////////////////////////
// LIFE CYCLE
//////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.layoutId = R.layout.fragment_no_reservation;
    }

//////////////////////////////////////////////////////////////////////////////////
// INTERACTION
//////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onMainBtnClick(View v) {
        super.onMainBtnClick(v);
    }
}
