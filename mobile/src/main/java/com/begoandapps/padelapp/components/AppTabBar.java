package com.begoandapps.padelapp.components;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.components.interfaces.IAppView;
import com.begoandapps.padelapp.view.interfaces.ITabBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bernatgomez on 11/4/17.
 */

public class AppTabBar extends LinearLayout implements IAppView {

    protected ITabBar callback;


//////////////////////////////////////////////////////////////////////////////////
// CONSTRUCTORS
//////////////////////////////////////////////////////////////////////////////////

    public AppTabBar(Context context) {
        super(context);

        this.init(context, null);
    }

    public AppTabBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        this.init(context, attrs);
    }

    public AppTabBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.init(context, attrs);
    }

    @TargetApi(21)
    public AppTabBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        this.init(context, attrs);

    }

    @Override
    public void init(Context context, AttributeSet attrs) {
        this.bindViews(context);
    }

    private void bindViews(Context cntxt) {
        LayoutInflater.from(cntxt).inflate(R.layout.view_tabbar, this, true);

        ButterKnife.bind(this);
    }

//////////////////////////////////////////////////////////////////////////////////
// ACCESSORS
//////////////////////////////////////////////////////////////////////////////////

    public ITabBar getCallback() {
        return callback;
    }

    public void setCallback(ITabBar callback) {
        this.callback = callback;
    }

//////////////////////////////////////////////////////////////////////////////////
// INTERACTION
//////////////////////////////////////////////////////////////////////////////////

    @OnClick(R.id.mainAction1)
    public void onGeoClick(View v) {
        if (this.callback != null) {
            this.callback.onGeoClick();
        }
    }

    @OnClick(R.id.mainAction2)
    public void onSearchClick(View v) {
        if (this.callback != null) {
            this.callback.onSearchClick();
        }
    }

    @OnClick(R.id.mainAction3)
    public void onProfileClick(View v) {
        if (this.callback != null) {
            this.callback.onProfileClick();
        }
    }
}

