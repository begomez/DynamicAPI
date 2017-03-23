package com.begoandapps.padelapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.begoandapps.padelapp.MainApplication;
import com.begoandapps.padelapp.dependencies.ApplicationComponent;
import com.f2prateek.dart.Dart;
import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.components.AppToolbar;
import com.begoandapps.padelapp.view.interfaces.IBase;
import com.begoandapps.padelapp.view.interfaces.IMainAction;
import com.begoandapps.padelapp.view.interfaces.INavigable;
import com.begoandapps.padelapp.navigation.interfaces.INavigation;
import com.begoandapps.padelapp.persist.ActivityRepository;
import com.begoandapps.padelapp.utils.AndroidLoggerUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bernatgomez on 6/3/17.
 */

public class BaseActivity extends AppCompatActivity implements IBase, IMainAction, INavigable {

    private static final String TAG = BaseActivity.class.getSimpleName();

    @Nullable
    @BindView(R.id.app_toolbar)
    protected AppToolbar toolbar;

    protected int layoutId;

/////////////////////////////////////////////////////////////////////////////////////////
// LIFE CYCLE
/////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AndroidLoggerUtils.logMsg(TAG, TAG + ".onCreate()");

        ActivityRepository.getInstance().add(this);

    //XXX: features - content - toolbar

        //XXX: 1. features
        this.prepareWindow();

        //XXX: 2. content
        this.setContentView(this.layoutId);

        this.injectComponents();

        //XXX: 3. toolbar and others
        this.configViews();

        if (this.isActivityCreation(savedInstanceState)) {
            this.launchContentFragment();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        AndroidLoggerUtils.logMsg(TAG, TAG + ".onDestroy()");

        ActivityRepository.getInstance().remove(this);
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
// IBASE IMPL
/////////////////////////////////////////////////////////////////////////////////////////

    private boolean isActivityCreation(Bundle state) {
        return state == null;
    }

    /**
     * Request window features inside this method
     */
    @Override
    public void prepareWindow() {

    }

    @Override
    public void injectComponents() {
        this.injectDependencies();
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
        ButterKnife.bind(this);
    }

    protected void injectExtras() {
        Dart.inject(this);
    }

    @Override
    public void configViews() {
        this.configToolBar();
    }

    /**
     *
     */
    protected void configToolBar() {
        if (this.hasToolbar()) {
            this.setSupportActionBar(this.toolbar);
            ActionBar bar = this.getSupportActionBar();

            bar.setDisplayHomeAsUpEnabled(true);
            bar.setDisplayShowTitleEnabled(true);
        }
    }

    private boolean hasToolbar() {
        return this.toolbar != null;
    }

    /**
     *
     */
    @Override
    public void launchContentFragment() {
        //TODO: implement on subclasses
    }

    @Override
    public ApplicationComponent getInjector()  {
        return ((MainApplication) this.getApplication()).getInjector();
    }

/////////////////////////////////////////////////////////////////////////////////////////
// IMAINACTION IMPL
/////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onMainBtnClick(View v) {

    }

/////////////////////////////////////////////////////////////////////////////////////////
// INAVIGABLE IMPL
/////////////////////////////////////////////////////////////////////////////////////////

    /**
     *
     * @param cmd
     */
    public void navigateToNext(INavigation cmd) {
        cmd.navigate();
    }

    /**
     *
     * @return
     */
    public INavigation getNavigationCmd() {
        //TODO: implement on subclasses
        return null;
    }

/////////////////////////////////////////////////////////////////////////////////////////
// BACK NAVIGATION
/////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
