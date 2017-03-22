package com.begoandapps.padelapp.dependencies;


import com.begoandapps.padelapp.view.LoginFacebookFragment;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by bernatgomez on 22/3/17.
 */
@Singleton
@Component(modules={MainModule.class, LoginModule.class})
public interface ApplicationComponent {
    public void inject(LoginFacebookFragment frag);
}
