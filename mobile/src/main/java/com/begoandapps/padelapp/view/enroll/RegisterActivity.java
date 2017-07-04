package com.begoandapps.padelapp.view.enroll;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.navigation.NavigationUtils;
import com.begoandapps.padelapp.view.core.BaseActivity;
import com.begoandapps.padelapp.view.dashboard.PadelActivity;

/**
 * Created by bernatgomez on 7/3/17.
 */
public class RegisterActivity extends BaseActivity implements RegisterSelectionFragment.IFacebookRegisterNav, RegisterFacebookFragment.IDashboardNav {

    private static final String TAG = RegisterActivity.class.getSimpleName();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.layoutId = R.layout.activity_register;

        super.onCreate(savedInstanceState);
    }

    @Override
    public void launchContentFragment() {
        super.launchContentFragment();

        NavigationUtils.launchFragment(
            this.getSupportFragmentManager(), RegisterSelectionFragment.newInstance(), CONTENT_FRAME);
    }

//////////////////////////////////////////////////////////////////////////////////////////////
// NAV INTERFACE IMPL
//////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void launchFacebookRegister() {
        NavigationUtils.launchFragment(this.getSupportFragmentManager(), RegisterFacebookFragment.newInstance(), R.id.content_frame, true);
    }

//////////////////////////////////////////////////////////////////////////////////////////////
// NAV INTERFACE IMPL
//////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void launchDashboard() {
        NavigationUtils.navigateToActivity(this, PadelActivity.class);
    }
}
