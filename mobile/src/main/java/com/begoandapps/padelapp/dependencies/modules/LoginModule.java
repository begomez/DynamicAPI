package com.begoandapps.padelapp.dependencies.modules;


import com.begoandapps.padel.usecases.login.LoginUseCase;
import com.begoandapps.padel.usecases.login.LoginUseCaseImpl;
import com.begoandapps.padelapp.dependencies.scopes.PerActivity;
import com.begoandapps.padelapp.presenter.LoginFacebookPresenter;
import com.squareup.otto.Bus;

import dagger.Module;
import dagger.Provides;
import rest.RestDataSource;


/**
 * Created by bernatgomez on 22/3/17.
 */
@Module
public class LoginModule {

    /**
     *
     * @return
     */
    @Provides
    @PerActivity
    public LoginFacebookPresenter provideFacebookPresenter(LoginUseCase useCase) {
        return new LoginFacebookPresenter(useCase);
    }

    @Provides
    @PerActivity
    public LoginUseCase provideLoginUsecase(Bus bus, RestDataSource rest) {
        return new LoginUseCaseImpl(bus, rest);
    }
}
