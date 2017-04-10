package com.begoandapps.padelapp.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.begoandapps.padelapp.dependencies.components.ApplicationComponent;
import com.begoandapps.padelapp.view.interfaces.IToggleToolbar;
import com.f2prateek.dart.Dart;
import com.begoandapps.padelapp.view.interfaces.IBase;
import com.begoandapps.padelapp.view.interfaces.IMainAction;
import com.begoandapps.padelapp.utils.AndroidLoggerUtils;


import butterknife.ButterKnife;

/**
 * Created by bernatgomez on 9/3/17.
 */

public class BaseFragment extends Fragment implements IBase, IMainAction {

    private static final String TAG = BaseFragment.class.getSimpleName();

    protected int layoutId;

    protected IToggleToolbar callbackToolbar;


/////////////////////////////////////////////////////////////////////////////////////////
// LIFE CYCLE
/////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AndroidLoggerUtils.logMsg(TAG, this.getClass().getSimpleName() + ".onCreate()");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        AndroidLoggerUtils.logMsg(TAG, this.getClass().getSimpleName() + ".onCreateView()");

        return LayoutInflater.from(this.getContext()).inflate(this.layoutId, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.injectElements();

        this.configViews();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.prepareWindow();

        //XXX: activity injector is needed, so we should call dagger from here
        this.injectDependencies();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        AndroidLoggerUtils.logMsg(TAG, this.getClass().getSimpleName() + ".onDestroy()");

    }

    @Override
    public void onStart() {
        super.onStart();

        this.bindPresentersAndViews();

        AndroidLoggerUtils.logMsg(TAG, this.getClass().getSimpleName() + ".onStart()");

    }

    @Override
    public void onStop() {
        super.onStop();

        AndroidLoggerUtils.logMsg(TAG, this.getClass().getSimpleName() + ".onStop()");
    }

    @Override
    public void onResume() {
        super.onResume();

        AndroidLoggerUtils.logMsg(TAG, this.getClass().getSimpleName() + ".onResume()");

    }

    @Override
    public void onPause() {
        super.onPause();

        AndroidLoggerUtils.logMsg(TAG, this.getClass().getSimpleName() + ".onPause()");

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.saveCallback(context);
    }

/////////////////////////////////////////////////////////////////////////////////////////
// IBASE IMPL
/////////////////////////////////////////////////////////////////////////////////////////

    /**
     *
     */
    @Override
    public void prepareWindow() {

    }

    /**
     *
     */
    protected void bindPresentersAndViews() {
        //TODO: use Dagger if needed
    }

    /**
     *
     */
    @Override
    public void injectElements() {
        //XXX: dependencies cannot be injected here
        this.injectViews();
        this.injectExtras();
    }

    /**
     *
     */
    protected void injectDependencies() {

    }

    /**
     *
     */
    protected void injectViews() {
        ButterKnife.bind(this, this.getView());
    }

    /**
     *
     */
    protected void injectExtras() {
        Dart.inject(this, this.getArguments());
    }

    /**
     *
     */
    @Override
    public void configViews() {

    }

    /**
     *
     */
    @Override
    public void launchContentFragment() {

    }

    /**
     *
     * @return
     */
    @Override
    public ApplicationComponent getApplicationComponent() {
        return ((BaseActivity) this.getActivity()).getApplicationComponent();
    }

    /**
     *
     * @param cntxt
     */
    protected void saveCallback(Context cntxt) {
        if (this.getActivity() instanceof IToggleToolbar) {
            this.callbackToolbar = (IToggleToolbar) this.getActivity();
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////
// IMAINACTION IMPL
/////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onMainBtnClick(View v) {

    }


/////////////////////////////////////////////////////////////////////////////////////////
// ITOGGLETOOLBAR
/////////////////////////////////////////////////////////////////////////////////////////

    public void showToolbar() {
        if (this.callbackToolbar != null) {
            this.callbackToolbar.showToolbar();
        }
    }

    public void hideToolbar() {
        if (this.callbackToolbar != null) {
            this.callbackToolbar.hideToolbar();
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////
// UTILS
/////////////////////////////////////////////////////////////////////////////////////////

    public String getComponentIdentifier() {
        return this.getClass().getSimpleName();
    }

}
