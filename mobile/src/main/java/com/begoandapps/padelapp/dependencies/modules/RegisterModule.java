package com.begoandapps.padelapp.dependencies.modules;


import com.begoandapps.padel.usecases.register.RegisterUseCase;
import com.begoandapps.padel.usecases.register.RegisterUseCaseImpl;
import com.begoandapps.padelapp.dependencies.scopes.PerActivity;
import com.begoandapps.padelapp.presenter.RegisterFacebookPresenter;
import com.squareup.otto.Bus;

import dagger.Module;
import dagger.Provides;
import rest.RestModuleDataSource;


/**
 * Created by bernatgomez on 22/3/17.
 */
@Module
public class RegisterModule {

    /**
     *
     * @return
     */
    @Provides
    @PerActivity
    public RegisterFacebookPresenter provideFacebookPresenter(RegisterUseCase useCase, Bus bus) {
        return new RegisterFacebookPresenter(useCase, bus);
    }

    /**
     *
     * @param bus
     * @param rest
     * @return
     */
    @Provides
    @PerActivity
    public RegisterUseCase provideLoginUsecase(Bus bus, RestModuleDataSource rest) {
        return new RegisterUseCaseImpl(bus, rest);
    }
}
