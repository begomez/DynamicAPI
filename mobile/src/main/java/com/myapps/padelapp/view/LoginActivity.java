package com.myapps.padelapp.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.myapps.padelapp.R;
import com.myapps.padelapp.navigation.NavigationUtis;

/**
 * Created by bernatgomez on 7/3/17.
 */
public class LoginActivity extends BaseActivity {

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
}
