package com.begoandapps.padelapp.view.interfaces;

import com.begoandapps.padelapp.view.core.interfaces.IView;

/**
 * Created by bernatgomez on 19/3/17.
 */

public interface IRegisterFacebookView extends IView {

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
    public void onRegisterSuccess();

    /**
     *
     */
    public void onRegisterError(String msg);
}
