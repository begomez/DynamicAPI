package com.begoandapps.padel.usecases.register;

import com.begoandapps.padel.usecases.BaseUseCase;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

import apimodels.ApiErrorModel;
import apimodels.Sample;
import rest.RestDataSource;

/**
 * Created by bernatgomez on 20/3/17.
 */

public class RegisterUseCaseImpl extends BaseUseCase implements RegisterUseCase {

    public RegisterUseCaseImpl(Bus bus, RestDataSource rest) {
        super(bus, rest);
        this.register();
    }

    @Override
    public void signUp(String user, String pass) {
        rest.createAPI().sampleCall();
    }

    @Override
    public void signOut() {

    }

    @Subscribe
    public void onSuccess(Sample sample) {
        this.unregister();
        this.bus.post(sample);

    }

    @Subscribe
    public void onError(ApiErrorModel error) {
        this.unregister();
        this.bus.post(error);
    }
}
