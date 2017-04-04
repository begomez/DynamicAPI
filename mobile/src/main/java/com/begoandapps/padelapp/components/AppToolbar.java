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

//////////////////////////////////////////////////////////////////////////////////
// CONSTRUCTORS
//////////////////////////////////////////////////////////////////////////////////

    public AppToolbar(Context context) {
        super(context);

        this.init(context, null);
    }

    public AppToolbar(Context context, @Nullable AttributeSet attrs) {

        super(context, attrs);

        this.init(context, attrs);
    }

    public AppToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.init(context, attrs);
    }

//////////////////////////////////////////////////////////////////////////////////
// IAAPVIEW IMPL
//////////////////////////////////////////////////////////////////////////////////

    @Override
    public void init(Context context, AttributeSet attrs) {
        //TODO
    }

    public void setTitle(String title) {
        this.setTitle(title);
    }
}
