package com.myapps.padelapp.view;

import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.myapps.padelapp.R;
import com.myapps.padelapp.navigation.BaseNavigation;
import com.myapps.padelapp.navigation.INavigation;
import com.myapps.padelapp.navigation.NavigationUtis;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.layoutId = R.layout.activity_splash;

        super.onCreate(savedInstanceState);

        this.launchNextModule();
    }

    @Override
    protected void prepareWindow() {
        super.prepareWindow();

        this.getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void launchNextModule() {
        new Handler().postDelayed(
            new Runnable() {
                @Override
                public void run() {
                    navigateToNext(getNavigationCmd());
                }
            },
            this.getResources().getInteger(R.integer.splash_delay_time))
        ;
    }

/////////////////////////////////////////////////////////////////////////////////////////
// NAVIGATION
/////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void navigateToNext(INavigation cmd) {
        super.navigateToNext(cmd);
    }

    @Override
    protected INavigation getNavigationCmd() {
        super.getNavigationCmd();

        INavigation cmd = new BaseNavigation() {

            @Override
            public void navigate() {
                NavigationUtis.navigateToActivity(SplashActivity.this, TutorialActivity.class);
            }
        };

        return cmd;
    }
}
