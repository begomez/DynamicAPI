package com.begoandapps.padelapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.begoandapps.padelapp.R;


/**
 * Created by bernatgomez on 4/4/17.
 */
public class SplashFragment extends BaseFragment {

/////////////////////////////////////////////////////////////////////////////////////////////
// CONSTRUCTORS
/////////////////////////////////////////////////////////////////////////////////////////////

    public static SplashFragment newInstance() {
        return new SplashFragment();
    }

    public SplashFragment() {
        super();
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// LIFE CYCLE
/////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.layoutId = R.layout.fragment_splash;
    }
}
