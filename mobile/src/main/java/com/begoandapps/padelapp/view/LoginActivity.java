package com.begoandapps.padelapp.view;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.navigation.NavigationUtis;

/**
 * Created by bernatgomez on 7/3/17.
 */
public class LoginActivity extends BaseActivity implements LoginSelectionFragment.ILoginTransaction {

    private static final String TAG = LoginActivity.class.getSimpleName();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.layoutId = R.layout.activity_login;

        super.onCreate(savedInstanceState);
    }

    @Override
    public void launchContentFragment() {
        super.launchContentFragment();

        NavigationUtis.launchFragment(
            this.getSupportFragmentManager(), LoginSelectionFragment.newInstance(), R.id.content_frame);
    }

//////////////////////////////////////////////////////////////////////////////////////////////
//
//////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void launchFacebookLogin() {
        NavigationUtis.launchFragment(this.getSupportFragmentManager(), LoginFacebookFragment.newInstance(), R.id.content_frame);
    }
}
