package com.begoandapps.padelapp.dependencies.modules;


import com.begoandapps.padel.usecases.login.RegisterUseCase;
import com.begoandapps.padel.usecases.login.RegisterUseCaseImpl;
import com.begoandapps.padelapp.dependencies.scopes.PerActivity;
import com.begoandapps.padelapp.presenter.LoginFacebookPresenter;
import com.squareup.otto.Bus;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rest.RestDataSource;


/**
 * Created by bernatgomez on 22/3/17.
 */
@Module
public class LoginModule extends BaseModule {

    /**
     *
     * @return
     */
    @Provides
    @PerActivity
    public LoginFacebookPresenter provideFacebookPresenter(RegisterUseCase useCase) {
        return new LoginFacebookPresenter(useCase);
    }

    @Provides
    @PerActivity
    public RegisterUseCase provideLoginUsecase(Bus bus, RestDataSource rest) {
        return new RegisterUseCaseImpl(bus, rest);
    }
}
