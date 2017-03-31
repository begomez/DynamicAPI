package com.begoandapps.padelapp.dependencies.components;


import com.begoandapps.padelapp.dependencies.modules.ApplicationModule;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Component;
import rest.RestDataSource;


/**
 * Created by bernatgomez on 22/3/17.
 */
@Singleton
@Component(modules={ApplicationModule.class})
public interface ApplicationComponent {

    /**
     *
     * @return
     */
    Bus getBus();

    /**
     *
     * @return
     */
    RestDataSource getRest();
}
