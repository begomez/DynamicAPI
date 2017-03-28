package com.begoandapps.padelapp.dependencies.components;


import com.begoandapps.padelapp.dependencies.modules.LoginModule;
import com.begoandapps.padelapp.dependencies.scopes.CustomScope;
import com.begoandapps.padelapp.dependencies.scopes.PerActivity;
import com.begoandapps.padelapp.view.LoginFacebookFragment;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by bernatgomez on 22/3/17.
 */
//@Singleton
@Component(dependencies = ApplicationComponent.class, modules={LoginModule.class})
public interface LoginComponent {
    public void inject(LoginFacebookFragment frag);
}
