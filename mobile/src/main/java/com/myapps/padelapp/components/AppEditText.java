package com.myapps.padelapp.components;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import com.myapps.padelapp.components.interfaces.IAppView;

/**
 * Created by bernatgomez on 19/3/17.
 */

public class AppEditText extends android.support.v7.widget.AppCompatEditText implements IAppView {

    public AppEditText(Context context) {
        super(context);
    }

    public AppEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AppEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void init(Context context, AttributeSet attrs) {

    }
}
