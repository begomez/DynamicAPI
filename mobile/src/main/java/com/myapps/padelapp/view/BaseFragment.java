package com.myapps.padelapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.f2prateek.dart.Dart;
import com.myapps.padelapp.view.interfaces.IBase;
import com.myapps.padelapp.view.interfaces.IMainAction;
import com.myapps.padelapp.utils.AndroidLoggerUtils;


import butterknife.ButterKnife;

/**
 * Created by bernatgomez on 9/3/17.
 */

public class BaseFragment extends Fragment implements IBase, IMainAction {

    private static final String TAG = BaseFragment.class.getSimpleName();

    protected int layoutId;

/////////////////////////////////////////////////////////////////////////////////////////
// LIFE CYCLE
/////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.prepareWindow();

        AndroidLoggerUtils.logMsg(TAG, TAG + ".onCreate()");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        AndroidLoggerUtils.logMsg(TAG, TAG + ".onCreateView()");

        return LayoutInflater.from(this.getContext()).inflate(this.layoutId, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.injectComponents();

        this.configViews();

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
// IBASE IMPL
/////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void prepareWindow() {

    }

    @Override
    public void injectComponents() {
        this.injectViews();
        this.injectExtras();
    }

    protected void injectViews() {
        ButterKnife.bind(this, this.getView());
    }

    protected void injectExtras() {
        Dart.inject(this, this.getArguments());
    }

    @Override
    public void configViews() {

    }

    @Override
    public void launchContentFragment() {

    }

/////////////////////////////////////////////////////////////////////////////////////////
// IMAINACTION IMPL
/////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onMainBtnClick(View v) {

    }


/////////////////////////////////////////////////////////////////////////////////////////
// UTILS
/////////////////////////////////////////////////////////////////////////////////////////

    protected String getComponentIdentifier() {
        return this.getClass().getSimpleName();
    }

}
