package com.begoandapps.padelapp.presenter;

import android.support.annotation.NonNull;

import com.begoandapps.padel.usecases.register.RegisterUseCase;
import com.begoandapps.padelapp.view.interfaces.IRegisterFacebookView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

import apimodels.ApiErrorModel;
import apimodels.Sample;

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

        this.usecase.signUp(user, pass);
    }

    private void launchThread(final String user, final String pass) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                registerWithFacebook(user, pass);
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

////////////////////////////////////////////////////////////////////////////////////////
// SUSCRIPTIONS
////////////////////////////////////////////////////////////////////////////////////////

    @Subscribe
    public void onSuccessResponse(Sample sample) {
        this.view.onRegisterSuccess();
    }

    @Subscribe
    public void onErrorResponse(ApiErrorModel error) {
        this.manageError(error);
        this.view.onRegisterSuccess();
    }
}
