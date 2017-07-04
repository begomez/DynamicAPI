package com.begoandapps.padelapp.view.core.interfaces;

import android.content.Context;

/**
 * Created by bernatgomez on 2/3/17.
 */

public interface IView {

    public Context getContext();

    public void showLoading();

    public void hideLoading();
}
