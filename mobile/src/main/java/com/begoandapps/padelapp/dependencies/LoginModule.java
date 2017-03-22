package com.begoandapps.padelapp.dependencies;


import com.begoandapps.padelapp.presenter.LoginFacebookPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by bernatgomez on 22/3/17.
 */
@Module
public class LoginModule {

    /**
     *
     * @return
     */
    @Singleton
    @Provides
    public LoginFacebookPresenter provideFacebookPresenter() {
        return new LoginFacebookPresenter();
    }
}
