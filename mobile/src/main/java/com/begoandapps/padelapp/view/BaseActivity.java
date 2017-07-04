package com.begoandapps.padelapp.view;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.begoandapps.padelapp.MainApplication;
import com.begoandapps.padelapp.dependencies.components.ApplicationComponent;
import com.begoandapps.padelapp.view.interfaces.IToggleToolbar;
import com.f2prateek.dart.Dart;
import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.components.AppToolbar;
import com.begoandapps.padelapp.view.interfaces.IBase;
import com.begoandapps.padelapp.view.interfaces.IMainAction;
import com.begoandapps.padelapp.view.interfaces.INavigable;
import com.begoandapps.padelapp.navigation.interfaces.INavigation;
import com.begoandapps.padelapp.persist.ActivityRepository;
import com.begoandapps.padelapp.utils.AndroidLoggerUtils;

import junit.framework.Assert;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Base class for activities
 *
 * Created by bernatgomez on 6/3/17.
 */
public class BaseActivity
        extends AppCompatActivity
        implements IBase, IMainAction, INavigable, IToggleToolbar {

    private static final String TAG = BaseActivity.class.getSimpleName();

    protected static final int CONTENT_FRAME = R.id.content_frame;

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

        AndroidLoggerUtils.logMsg(TAG, this.getClass().getSimpleName() + ".onCreate()");

        ActivityRepository.getInstance().add(this);

    //XXX: features - content - injection - views (toolbar)

        //XXX: 1. features
        this.prepareWindow();

        //XXX: 2. content
        this.setContentView(this.layoutId);

        //XXX: 3. injection
        this.injectElements();

        //XXX: 4. views (toolbar and others)
        this.configViews();

        if (this.isActivityCreation(savedInstanceState)) {
            this.launchContentFragment();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        AndroidLoggerUtils.logMsg(TAG, this.getClass().getSimpleName() + ".onDestroy()");

        ActivityRepository.getInstance().remove(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        AndroidLoggerUtils.logMsg(TAG, this.getClass().getSimpleName() + ".onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        AndroidLoggerUtils.logMsg(TAG, this.getClass().getSimpleName() + ".onPause()");
    }

    @Override
    protected void onStart() {
        super.onStart();

        AndroidLoggerUtils.logMsg(TAG, this.getClass().getSimpleName() + ".onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        AndroidLoggerUtils.logMsg(TAG, this.getClass().getSimpleName() + ".onStop()");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        AndroidLoggerUtils.logMsg(TAG, this.getClass().getSimpleName() + ".onNewIntent()");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                this.onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////
// IBASE IMPL
/////////////////////////////////////////////////////////////////////////////////////////

    /**
     *
     * @param state
     * @return
     */
    private boolean isActivityCreation(Bundle state) {
        return state == null;
    }

    /**
     * Request window features inside this method
     */
    @Override
    public void prepareWindow() {
    }

    /**
     *
     */
    @Override
    public void injectElements() {
        this.injectDependencies();
        this.injectViews();
        this.injectExtras();
        this.onInjectionFinished();
    }

    /**
     *
     */
    protected void injectDependencies() {}

    /**
     *
     */
    protected void injectViews() {
        ButterKnife.bind(this);
    }

    /**
     *
     */
    protected void injectExtras() {
        Dart.inject(this);
    }

    /**
     *
     */
    protected void onInjectionFinished() {}

    @Override
    public void configViews() {

        this.configToolBar();
    }

    /**
     *
     */
    protected void configToolBar() {

        // TOOLBAR
        if (this.hasToolbar()) {
            this.setSupportActionBar(this.toolbar);
            ActionBar bar = this.getSupportActionBar();

            bar.setDisplayHomeAsUpEnabled(true);
            bar.setDisplayShowTitleEnabled(true);
        }
    }

    /**
     *
     * @return
     */
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
    public ApplicationComponent getApplicationComponent()  {
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
    public void navigateTo(INavigation cmd) {
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
// TOOLBAR IMPL
/////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void showToolbar() {
        if (this.hasToolbar()) {
            this.toolbar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideToolbar() {
        if (this.hasToolbar()) {
            this.toolbar.setVisibility(View.GONE);
        }
    }

    @Override
    public void customizeToolbar(AppToolbar.Data data) {
        if (this.hasToolbar()) {

            if (data.showIcon) {
                this.toolbar.setIcon(data.icon);
                this.toolbar.showIcon();
            } else {
                this.toolbar.hideIcon();
                //this.getSupportActionBar().setIcon(null);
            }

            this.toolbar.setBackColor(this.getResources().getColor(data.backColor));

            this.toolbar.setForeColor(this.getResources().getColor(data.foreColor));

            this.toolbar.setTitle(data.title);
        }
    }

    @Override
    public void resetToolbar() {
        if (this.hasToolbar()) {
            this.toolbar.reset();
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////
// BACK NAVIGATION
/////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
