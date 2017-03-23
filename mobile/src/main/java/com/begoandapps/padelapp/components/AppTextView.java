package com.begoandapps.padelapp.components;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.begoandapps.padelapp.components.interfaces.IAppView;

/**
 * Created by bernatgomez on 7/3/17.
 */

public class AppTextView extends TextView implements IAppView {

//////////////////////////////////////////////////////////////////////////////////
// CONSTRUCTORS
//////////////////////////////////////////////////////////////////////////////////

    public AppTextView(Context context) {
        super(context);
    }

    public AppTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AppTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public AppTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

//////////////////////////////////////////////////////////////////////////////////
// IAPPVIEW IMPL
//////////////////////////////////////////////////////////////////////////////////

    @Override
    public void init(Context context, AttributeSet attrs) {

    }

//////////////////////////////////////////////////////////////////////////////////
// ACCESSORS
//////////////////////////////////////////////////////////////////////////////////

    public void setCustomText(int id) {
        this.setCustomText(this.getResources().getString(id));
    }

    public void setCustomText(String txt) {
        this.setText(txt);
    }

}
