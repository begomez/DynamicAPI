package com.begoandapps.padelapp.dependencies.modules;


import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rest.RestDataSource;
import rest.interfaces.IDataSource;


/**
 * Created by bernatgomez on 22/3/17.
 */
@Module
public class BaseModule {

    @Provides
    //@Singleton
    public Bus provideBus() {
        return new Bus();
    }

    @Provides
    //@Singleton
    public RestDataSource provideRest(Bus bus) {
        return new RestDataSource(bus);
    }
}
