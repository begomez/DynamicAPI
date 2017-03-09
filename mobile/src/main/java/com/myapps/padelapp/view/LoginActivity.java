package com.myapps.padelapp.view;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.myapps.padelapp.R;

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
    protected void configToolBar() {
        super.configToolBar();
    }
}
