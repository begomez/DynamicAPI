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
    public void signUp(String user, String pass);

    /**
     *
     */
    public void signOut();
}
