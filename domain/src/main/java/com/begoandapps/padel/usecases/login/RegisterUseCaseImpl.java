package com.begoandapps.padel.usecases.login;

import com.begoandapps.padel.usecases.BaseUseCase;
import com.squareup.otto.Bus;

import rest.RestDataSource;

/**
 * Created by bernatgomez on 20/3/17.
 */

public class RegisterUseCaseImpl extends BaseUseCase implements RegisterUseCase {


    public RegisterUseCaseImpl() {
        super();
    }


    //@Inject
    public RegisterUseCaseImpl(Bus bus, RestDataSource rest) {
        super(bus, rest);
    }

    @Override
    public void signUp(String user, String pass) {

    }

    @Override
    public void signOut() {

    }
}
