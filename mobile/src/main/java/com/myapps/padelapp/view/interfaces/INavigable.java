package com.myapps.padelapp.view.interfaces;

import com.myapps.padelapp.navigation.interfaces.INavigation;

/**
 * Created by bernatgomez on 13/3/17.
 */

public interface INavigable {

    public INavigation getNavigationCmd();

    public void navigateToNext(INavigation cmd);

}
