package com.begoandapps.padelapp.view.interfaces;

import com.begoandapps.padelapp.navigation.interfaces.INavigation;

/**
 * Created by bernatgomez on 13/3/17.
 */

public interface INavigable {

    /**
     *
     * @return
     */
    public INavigation getNavigationCmd();

    /**
     *
     * @param cmd
     */
    public void navigateTo(INavigation cmd);

}
