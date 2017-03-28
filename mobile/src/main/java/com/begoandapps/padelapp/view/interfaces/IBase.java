package com.begoandapps.padelapp.view.interfaces;

import com.begoandapps.padelapp.dependencies.ApplicationComponent;
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
    public void injectComponents();

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
    public ApplicationComponent getInjector() throws NoDependencyInjectorException;
}