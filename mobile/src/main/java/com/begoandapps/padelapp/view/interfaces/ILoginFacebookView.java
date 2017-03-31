package com.begoandapps.padelapp.view.interfaces;

/**
 * Created by bernatgomez on 19/3/17.
 */

public interface ILoginFacebookView extends IView {

    /**
     *
     * @return
     */
    public String getUser();

    /**
     *
     * @return
     */
    public String getPassword();

    /**
     *
     */
    public void onLoginSuccess();

    /**
     *
     */
    public void onLoginError(String msg);
}
