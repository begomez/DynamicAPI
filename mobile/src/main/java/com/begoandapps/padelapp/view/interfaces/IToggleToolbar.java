package com.begoandapps.padelapp.view.interfaces;

import com.begoandapps.padelapp.components.AppToolbar;

/**
 * Created by bernatgomez on 4/4/17.
 */

public interface IToggleToolbar {
    public void showToolbar();
    public void hideToolbar();
    public void customizeToolbar(AppToolbar.Data data);
    public void resetToolbar();
}
