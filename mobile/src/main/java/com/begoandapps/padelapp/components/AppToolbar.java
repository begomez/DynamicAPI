package com.begoandapps.padelapp.components;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;

import com.begoandapps.padelapp.components.interfaces.IAppView;

/**
 * Created by bernatgomez on 9/3/17.
 */

public class AppToolbar extends Toolbar implements IAppView {

    public AppToolbar(Context context) {
        super(context);
    }

    public AppToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AppToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void init(Context context, AttributeSet attrs) {
        //TODO
    }
}
