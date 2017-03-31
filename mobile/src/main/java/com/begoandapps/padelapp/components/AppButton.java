package com.begoandapps.padelapp.components;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import com.begoandapps.padelapp.components.interfaces.IAppView;

/**
 * Created by bernatgomez on 9/3/17.
 */

public class AppButton extends Button implements IAppView {

//////////////////////////////////////////////////////////////////////////////////
// CONSTRUCTORS
//////////////////////////////////////////////////////////////////////////////////

    public AppButton(Context context) {
        super(context);

        this.init(context, null);
    }

    public AppButton(Context context, AttributeSet attrs) {

        super(context, attrs);

        this.init(context, null);
    }

    public AppButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.init(context, null);
    }

    @TargetApi(21)
    public AppButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        this.init(context, null);
    }

//////////////////////////////////////////////////////////////////////////////////
// IAPPVIEW IMPL
//////////////////////////////////////////////////////////////////////////////////

    @Override
    public void init(Context context, AttributeSet attrs) {

    }
}
