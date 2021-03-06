package com.begoandapps.padel.usecases.register;

import com.begoandapps.padel.usecases.BaseUseCase;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.Set;

import apimodels.ApiErrorModel;
import apimodels.Sample;
import rest.RestModuleDataSource;
import rest.exceptions.ModuleNotFoundException;
import rest.modules.GithubModuleImpl;

/**
 * Created by bernatgomez on 20/3/17.
 */

public class RegisterUseCaseImpl extends BaseUseCase implements RegisterUseCase {

    public RegisterUseCaseImpl(Bus bus, RestModuleDataSource rest) {
        super(bus, rest);

        this.rest.registerAllRestModules();
    }

    @Override
    public void signUp(String user, String pass) {
        this.register();

        try {
            Set<String> availableModules = this.rest.getAvailableModules();

            String targetModule = availableModules.iterator().next();

            GithubModuleImpl impl = this.rest.getModule(targetModule);

            impl.fakeSignUp("status:open");

        } catch (ModuleNotFoundException e) {
            //TODO: do something
        }
    }

    @Override
    public void signOut() {

    }

/////////////////////////////////////////////////////////////////////////////////////////////
// SUSCRIPTIONS
/////////////////////////////////////////////////////////////////////////////////////////////

    @Subscribe
    public void onSuccess(Sample sample) {
        this.unregister();
        this.bus.post(sample.getSubject());

    }

    @Subscribe
    public void onError(ApiErrorModel error) {
        this.unregister();
        this.bus.post(error);
    }
}
