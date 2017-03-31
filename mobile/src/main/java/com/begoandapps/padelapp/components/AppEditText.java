package com.begoandapps.padelapp.components;

import android.content.Context;
import android.util.AttributeSet;

import com.begoandapps.padelapp.components.interfaces.IAppView;

/**
 * Created by bernatgomez on 19/3/17.
 */

public class AppEditText extends android.support.v7.widget.AppCompatEditText implements IAppView {

//////////////////////////////////////////////////////////////////////////////////
// CONSTRUCTORS
//////////////////////////////////////////////////////////////////////////////////

    public AppEditText(Context context) {
        super(context);

        this.init(context, null);
    }

    public AppEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.init(context, attrs);
    }

    public AppEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.init(context, attrs);
    }

//////////////////////////////////////////////////////////////////////////////////
// IAPPVIEW IMPL
//////////////////////////////////////////////////////////////////////////////////

    @Override
    public void init(Context context, AttributeSet attrs) {

    }
}
