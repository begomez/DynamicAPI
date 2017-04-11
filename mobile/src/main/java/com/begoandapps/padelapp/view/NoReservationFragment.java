package com.begoandapps.padelapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.begoandapps.padelapp.R;

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
}
