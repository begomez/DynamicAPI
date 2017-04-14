package com.begoandapps.padel.usecases.register;

import com.begoandapps.padel.usecases.BaseUseCase;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import apimodels.ApiErrorModel;
import apimodels.Sample;
import rest.RestModuleDataSource;
import rest.exceptions.ModuleNotFoundException;
import rest.modulecontainer.interfaces.IModuleContainer;
import rest.modules.GithubModuleImpl;

/**
 * Created by bernatgomez on 20/3/17.
 */

public class RegisterUseCaseImpl extends BaseUseCase implements RegisterUseCase {

    public RegisterUseCaseImpl(Bus bus, RestModuleDataSource rest) {
        super(bus, rest);

        this.rest.registerModules();
    }

    @Override
    public void signUp(String user, String pass) {
        this.register();

        try {
            GithubModuleImpl impl = this.rest.getModule(IModuleContainer.MODULE_GITHUB);

            impl.fakeSignUp("status:open");

        } catch (ModuleNotFoundException e) {
            //TODO: do dome
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
