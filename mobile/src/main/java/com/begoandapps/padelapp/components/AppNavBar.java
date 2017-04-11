package com.begoandapps.padelapp.components;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.components.interfaces.IAppView;

import butterknife.ButterKnife;

/**
 * Created by bernatgomez on 11/4/17.
 */

public class AppNavBar extends LinearLayout implements IAppView {


    public AppNavBar(Context context) {
        super(context);

        this.init(context, null);
    }

    public AppNavBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        this.init(context, attrs);
    }

    public AppNavBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.init(context, attrs);
    }

    @TargetApi(21)
    public AppNavBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        this.init(context, attrs);

    }

    @Override
    public void init(Context context, AttributeSet attrs) {
        this.bindViews(context);
    }

    private void bindViews(Context cntxt) {
        LayoutInflater.from(cntxt).inflate(R.layout.view_navbar, this, true);

        ButterKnife.bind(this);
    }
}
