package com.begoandapps.padelapp.components.interfaces;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by bernatgomez on 12/4/17.
 */

public interface IAttrView extends IAppView {
    public void extractAttrs(Context cntxt, AttributeSet attrs);
    public void createData();
    public void bindViews(Context cntxt);
    public void configViews();
}
