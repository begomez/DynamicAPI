package com.begoandapps.padelapp;


import android.app.Application;
import android.content.res.Configuration;

import com.begoandapps.padelapp.dependencies.components.ApplicationComponent;
import com.begoandapps.padelapp.dependencies.components.DaggerApplicationComponent;
import com.begoandapps.padelapp.utils.AndroidLoggerUtils;
import com.begoandapps.padelapp.utils.FontUtils;


/**
 * Created by bernatgomez on 6/3/17.
 */

//TODO: detect going to background

public class MainApplication extends Application {

    private static final String TAG = MainApplication.class.getSimpleName();

    private ApplicationComponent injector;


/////////////////////////////////////////////////////////////////////////
// LIFE CYCLE
/////////////////////////////////////////////////////////////////////////

    @Override
    public void onCreate() {
        super.onCreate();

        this.initInjector();

        this.initFonts();

        AndroidLoggerUtils.logMsg(TAG, "onCreate()");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        AndroidLoggerUtils.logMsg(TAG, "onTerminate()");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        AndroidLoggerUtils.logMsg(TAG, "onConfigurationChanged()");

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

        AndroidLoggerUtils.logMsg(TAG, "onLowMemory()");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);

        AndroidLoggerUtils.logMsg(TAG, "onTrimMemory()");
    }

/////////////////////////////////////////////////////////////////////////
// HELPERS
/////////////////////////////////////////////////////////////////////////

    private void initInjector() {
        this.injector = DaggerApplicationComponent.builder().build();
    }

    private void initFonts() {
        FontUtils.loadFonts(this.getAssets());
    }

/////////////////////////////////////////////////////////////////////////
// ACCESSORS
/////////////////////////////////////////////////////////////////////////

    public ApplicationComponent getInjector() {
        return injector;
    }

}
