package com.begoandapps.padelapp.dependencies.modules;


import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rest.RestDataSource;


/**
 * Created by bernatgomez on 22/3/17.
 */
@Module
public class ApplicationModule {

    @Provides
    @Singleton
    public Bus provideBus() {
        return new Bus();
    }

    @Provides
    @Singleton
    public RestDataSource provideRest(Bus bus) {
        return new RestDataSource(bus);
    }

}
