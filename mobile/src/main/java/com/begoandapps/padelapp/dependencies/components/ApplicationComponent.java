package com.begoandapps.padelapp.dependencies.components;


import com.begoandapps.padelapp.dependencies.modules.ApplicationModule;
import com.begoandapps.padelapp.dependencies.modules.LoginModule;
import com.begoandapps.padelapp.dependencies.scopes.CustomScope;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by bernatgomez on 22/3/17.
 */
@Singleton
@Component(modules={ApplicationModule.class})
public interface ApplicationComponent {

}
