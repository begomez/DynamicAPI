package com.begoandapps.padelapp.presenter;

import android.support.annotation.NonNull;

import com.begoandapps.padel.usecases.login.RegisterUseCase;
import com.begoandapps.padelapp.view.interfaces.IRegisterFacebookView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Inject;

/**
 * Created by bernatgomez on 20/3/17.
 */

public class RegisterFacebookPresenter extends BasePresenter<IRegisterFacebookView> {

    /**
     *
     */
    protected RegisterUseCase usecase;

////////////////////////////////////////////////////////////////////////////////////////
// CONSTRUCTORS
////////////////////////////////////////////////////////////////////////////////////////

    @Inject
    public RegisterFacebookPresenter(RegisterUseCase useCase) {
        super();

        this.usecase = useCase;
    }

////////////////////////////////////////////////////////////////////////////////////////
// OPERATIONS
////////////////////////////////////////////////////////////////////////////////////////
    public void doRegistration() {
        final String user = this.view.getUser();
        final String pass = this.view.getPassword();

        new Thread() {
            @Override
            public void run() {
                super.run();
                registerWithFacebook(user, pass);
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
    private void registerWithFacebook(final String user, final String pass) {

        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(user, pass)
                .addOnCompleteListener(
                    new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if (task.isSuccessful()) {
                               view.onRegisterSuccess();

                           } else {
                               view.onRegisterError(task.getException().toString());
                           }
                       }
                   }
                );
    }

}
