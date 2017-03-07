package com.myapps.padelapp.view;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.myapps.padelapp.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_splash);
    }

    @Override
    protected void configWindow() {
        super.configWindow();

        this.getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
