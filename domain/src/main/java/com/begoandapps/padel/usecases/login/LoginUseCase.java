package com.begoandapps.padel.usecases.login;

/**
 * Created by bernatgomez on 28/3/17.
 */

public interface RegisterUseCase {

    /**
     *
     * @param user
     * @param pass
     */
    public void login(String user, String pass);

    /**
     *
     */
    public void logout();
}
