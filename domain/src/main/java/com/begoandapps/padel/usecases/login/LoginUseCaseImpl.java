package com.begoandapps.padel.usecases.login;

import com.begoandapps.padel.usecases.BaseUseCase;
import com.squareup.otto.Bus;

import rest.RestDataSource;

/**
 * Created by bernatgomez on 20/3/17.
 */

public class LoginUseCaseImpl extends BaseUseCase implements LoginUseCase {


    public LoginUseCaseImpl() {
        super();
    }


    //@Inject
    public LoginUseCaseImpl(Bus bus, RestDataSource rest) {
        super(bus, rest);
    }

    @Override
    public void login(String user, String pass) {

    }

    @Override
    public void logout() {

    }
}
