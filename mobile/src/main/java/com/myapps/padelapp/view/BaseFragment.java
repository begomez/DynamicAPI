package com.myapps.padelapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myapps.padelapp.utils.AndroidLoggerUtils;

import java.util.zip.Inflater;

/**
 * Created by bernatgomez on 9/3/17.
 */

public class BaseFragment extends Fragment {

    private static final String TAG = BaseFragment.class.getSimpleName();

    protected int layoutId;

/////////////////////////////////////////////////////////////////////////////////////////
// LIFE CYCLE
/////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AndroidLoggerUtils.logMsg(TAG, TAG + ".onCreate()");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View v = LayoutInflater.from(this.getContext()).inflate(this.layoutId, container, false);

        AndroidLoggerUtils.logMsg(TAG, TAG + ".onCreateView()");

        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        AndroidLoggerUtils.logMsg(TAG, TAG + ".onDestroy()");

    }

    @Override
    public void onStart() {
        super.onStart();

        AndroidLoggerUtils.logMsg(TAG, TAG + ".onStart()");

    }

    @Override
    public void onStop() {
        super.onStop();

        AndroidLoggerUtils.logMsg(TAG, TAG + ".onStop()");

    }

    @Override
    public void onResume() {
        super.onResume();

        AndroidLoggerUtils.logMsg(TAG, TAG + ".onResume()");

    }

    @Override
    public void onPause() {
        super.onPause();

        AndroidLoggerUtils.logMsg(TAG, TAG + ".onPause()");

    }

/////////////////////////////////////////////////////////////////////////////////////////
// INTERACTION
/////////////////////////////////////////////////////////////////////////////////////////

    public void onMainBtnClick(View v) {

    }

/////////////////////////////////////////////////////////////////////////////////////////
// UTILS
/////////////////////////////////////////////////////////////////////////////////////////

    protected String getComponentIdentifier() {
        return this.getClass().getSimpleName();
    }

}
