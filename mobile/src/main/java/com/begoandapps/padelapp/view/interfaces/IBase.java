package com.begoandapps.padelapp.view.interfaces;

import com.begoandapps.padelapp.dependencies.components.ApplicationComponent;
import com.begoandapps.padelapp.exceptions.NoDependencyInjectorException;

/**
 * Created by bernatgomez on 14/3/17.
 */

public interface IBase {

    /**
     *
     */
    public void prepareWindow();

    /**
     *
     */
    public void injectViewsAndExtras();

    /**
     *
     */
    public void configViews();

    /**
     *
     */
    public void launchContentFragment();

    /**
     *
     * @return
     */
    public ApplicationComponent getApplicationComponent() throws NoDependencyInjectorException;
}
