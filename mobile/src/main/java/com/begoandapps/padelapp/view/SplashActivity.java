package com.begoandapps.padelapp.view;

import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.navigation.BaseNavigation;
import com.begoandapps.padelapp.navigation.interfaces.INavigation;
import com.begoandapps.padelapp.navigation.NavigationUtils;

public class SplashActivity extends BaseActivity {

//////////////////////////////////////////////////////////////////////////////////
// LIFE CYCLE
//////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.layoutId = R.layout.activity_splash;

        super.onCreate(savedInstanceState);

        this.launchNextModule();
    }

//////////////////////////////////////////////////////////////////////////////////
// ARCHITECTURE
//////////////////////////////////////////////////////////////////////////////////

    @Override
    public void prepareWindow() {
        super.prepareWindow();

        this.getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public void launchContentFragment() {
        super.launchContentFragment();

        NavigationUtils.launchFragment(this.getSupportFragmentManager(), SplashFragment.newInstance(), CONTENT_FRAME);
    }

    private void launchNextModule() {
        new Handler().postDelayed(
            new Runnable() {
                @Override
                public void run() {
                    navigateTo(getNavigationCmd());
                }
            },
            this.getResources().getInteger(R.integer.splash_delay_time))
        ;
    }

/////////////////////////////////////////////////////////////////////////////////////////
// NAVIGATION
/////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void navigateTo(INavigation cmd) {
        super.navigateTo(cmd);
    }

    @Override
    public INavigation getNavigationCmd() {
        super.getNavigationCmd();

        INavigation cmd = new BaseNavigation() {

            @Override
            public void navigate() {
                NavigationUtils.navigateToActivity(SplashActivity.this, TutorialActivity.class);
            }
        };

        return cmd;
    }
}
