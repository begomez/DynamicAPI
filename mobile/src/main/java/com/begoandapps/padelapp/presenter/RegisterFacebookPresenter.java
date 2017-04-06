package com.begoandapps.padelapp.presenter;

import android.support.annotation.NonNull;

import com.begoandapps.padel.usecases.register.RegisterUseCase;
import com.begoandapps.padelapp.utils.AndroidLoggerUtils;
import com.begoandapps.padelapp.view.interfaces.IRegisterFacebookView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.ProviderQueryResult;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

import apimodels.ApiErrorModel;
import apimodels.Sample;

/**
 * Created by bernatgomez on 20/3/17.
 */

public class RegisterFacebookPresenter extends BasePresenter<IRegisterFacebookView> {

    private static final String TAG = RegisterFacebookPresenter.class.getSimpleName();

    /**
     *
     */
    protected RegisterUseCase usecase;

////////////////////////////////////////////////////////////////////////////////////////
// CONSTRUCTORS
////////////////////////////////////////////////////////////////////////////////////////

    @Inject
    public RegisterFacebookPresenter(RegisterUseCase useCase, Bus bus) {
        super(bus);

        this.usecase = useCase;
    }

////////////////////////////////////////////////////////////////////////////////////////
// OPERATIONS
////////////////////////////////////////////////////////////////////////////////////////
    public void doRegistration() {
        final String user = this.getView().getUser();
        final String pass = this.getView().getPassword();

        //TODO: un/comment

        //this.isRegistered(user, pass, completion);

        this.usecase.signUp(user, pass);
    }


    private void launchRegister(final String user, final String pass) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                registerWithFacebook(user, pass);
            }
        }.start();

    }

    private void launchLogin(final String user, final String pass) {
        new Thread() {
            @Override
            public void run() {
                super.run();

                loginWithFacebook(user, pass);
            }
        }.start();
    }

    private void isRegistered(final String user, final String pass, final ICompletion completion) {
        Task<ProviderQueryResult> result = FirebaseAuth.getInstance().fetchProvidersForEmail(user).addOnCompleteListener(new OnCompleteListener<ProviderQueryResult>() {
            @Override
            public void onComplete(@NonNull Task<ProviderQueryResult> task) {
                if (task.isSuccessful()) {
                    for (String str : task.getResult().getProviders()) {
                        AndroidLoggerUtils.logMsg(TAG, "provider: " + str);
                    }

                    completion.done(user, pass, !task.getResult().getProviders().isEmpty());

                } else {
                    completion.done(user, pass, false);
                }
            }
        });
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
                               getView().onRegisterSuccess();

                           } else {
                               //view.onRegisterSuccess();
                               getView().onRegisterError(task.getException().toString());
                           }
                       }
                   }
                );
    }

    private void logOut() {
        FirebaseAuth.getInstance().signOut();
    }

    private void loginWithFacebook(final String user, final String pass) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    getView().onRegisterSuccess();
                } else {
                    getView().onRegisterError(task.getException().toString());
                }
            }
        });
    }

    public interface ICompletion {
        public void done(final String user, final String pass, boolean registered);
    }

    ICompletion completion = new ICompletion() {
        @Override
        public void done(final String user, final String pass, boolean registered) {
            if (registered) {
                launchLogin(user, pass);

            } else {

                //TODO: do something else...
                //launchRegister(user, pass);
            }
        }
    };

////////////////////////////////////////////////////////////////////////////////////////
// SUSCRIPTIONS
////////////////////////////////////////////////////////////////////////////////////////

    @Subscribe
    public void onSuccessResponse(String sample) {
        AndroidLoggerUtils.logMsg(TAG, "sample: " + sample);

        getView().onRegisterSuccess();
    }

    @Subscribe
    public void onErrorResponse(ApiErrorModel error) {
        this.manageError(error);
    }
}
