package com.myapps.padelapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.myapps.padelapp.navigation.INavigation;
import com.myapps.padelapp.persist.ActivityRepository;
import com.myapps.padelapp.utils.AndroidLoggerUtils;

/**
 * Created by bernatgomez on 6/3/17.
 */

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();

/////////////////////////////////////////////////////////////////////////////////////////
// LIFE CYCLE
/////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AndroidLoggerUtils.logMsg(TAG, TAG + ".onCreate()");

        ActivityRepository.getInstance().add(this);

        this.configWindow();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        AndroidLoggerUtils.logMsg(TAG, TAG + ".onDestroy()");

        ActivityRepository.getInstance().remove(this);
    }

    /**
     * Request window features inside this method
     */
    protected void configWindow() {

    }

    @Override
    protected void onResume() {
        super.onResume();

        AndroidLoggerUtils.logMsg(TAG, TAG + ".onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        AndroidLoggerUtils.logMsg(TAG, TAG + ".onPause()");

    }

    @Override
    protected void onStart() {
        super.onStart();

        AndroidLoggerUtils.logMsg(TAG, TAG + ".onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        AndroidLoggerUtils.logMsg(TAG, TAG + ".onStop()");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        AndroidLoggerUtils.logMsg(TAG, TAG + ".onNewIntent()");
    }

/////////////////////////////////////////////////////////////////////////////////////////
// NAVIGATION
/////////////////////////////////////////////////////////////////////////////////////////

    /**
     *
     * @param cmd
     */
    protected void navigateToNext(INavigation cmd) {
        cmd.navigate();
    }

    /**
     *
     * @return
     */
    protected INavigation getNavigationCmd() {
        return null;
    }

}
