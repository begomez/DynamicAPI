package com.begoandapps.padelapp.presenter;

import android.support.annotation.NonNull;

import com.begoandapps.padel.usecases.login.LoginUseCase;
import com.begoandapps.padelapp.view.interfaces.ILoginFacebookView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Inject;

/**
 * Created by bernatgomez on 20/3/17.
 */

public class LoginFacebookPresenter extends BasePresenter<ILoginFacebookView> {

    /**
     *
     */
    protected LoginUseCase usecase;

////////////////////////////////////////////////////////////////////////////////////////
// CONSTRUCTORS
////////////////////////////////////////////////////////////////////////////////////////

    @Inject
    public LoginFacebookPresenter(LoginUseCase useCase) {
        super();

        this.usecase = useCase;
    }

////////////////////////////////////////////////////////////////////////////////////////
// OPERATIONS
////////////////////////////////////////////////////////////////////////////////////////
    public void doLogin() {
        final String user = this.view.getUser();
        final String pass = this.view.getPassword();

        new Thread() {
            @Override
            public void run() {
                super.run();
                loginWithFacebook(user, pass);
            }
        }.start();

    }

    public void doLogout() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                FirebaseAuth.getInstance().signOut();
            }
        }.start();
    }

    //TODO: move to controller
    private void loginWithFacebook(final String user, final String pass) {

        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(user, pass)
                .addOnCompleteListener(
                    new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if (task.isSuccessful()) {
                               view.onLoginSuccess();

                           } else {
                               view.onLoginError(task.getException().toString());
                           }
                       }
                   }
                );
    }

}
