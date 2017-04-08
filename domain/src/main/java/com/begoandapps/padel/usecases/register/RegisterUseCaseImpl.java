package com.begoandapps.padel.usecases.register;

import com.begoandapps.padel.usecases.BaseUseCase;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import apimodels.ApiErrorModel;
import apimodels.Sample;
import rest.RestModuleDataSource;

/**
 * Created by bernatgomez on 20/3/17.
 */

public class RegisterUseCaseImpl extends BaseUseCase implements RegisterUseCase {

    public RegisterUseCaseImpl(Bus bus, RestModuleDataSource rest) {
        super(bus, rest);
        this.register();
    }

    @Override
    public void signUp(String user, String pass) {
        this.rest.fakeRegistration2();

        this.rest.sampleCall();
    }

    @Override
    public void signOut() {

    }

    @Subscribe
    public void onSuccess(Sample sample) {
        this.unregister();
        this.bus.post(sample.getSubject());

    }

    @Subscribe
    public void onError(ApiErrorModel error) {
        this.unregister();
        this.bus.post(error);
    }
}
