package com.begoandapps.padelapp.presenter;

import com.begoandapps.padelapp.view.interfaces.ILoginFacebookView;
import com.begoandapps.padelapp.view.interfaces.IView;

import javax.inject.Inject;

/**
 * Created by bernatgomez on 20/3/17.
 */

public class LoginFacebookPresenter extends BasePresenter<ILoginFacebookView> {

////////////////////////////////////////////////////////////////////////////////////////
// CONSTRUCTORS
////////////////////////////////////////////////////////////////////////////////////////

    public LoginFacebookPresenter() {
        super();
    }


////////////////////////////////////////////////////////////////////////////////////////
// OPERATIONS
////////////////////////////////////////////////////////////////////////////////////////
    public void doLogin() {
        String user = this.view.getPassword();
        String pass = this.view.getUser();
    }


}
