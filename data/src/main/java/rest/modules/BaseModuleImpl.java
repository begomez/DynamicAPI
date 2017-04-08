package rest.modules;

import com.squareup.otto.Bus;

import javax.inject.Inject;

import rest.modules.interfaces.IModule;
import retrofit2.Retrofit;

/**
 * Created by bernatgomez on 6/4/17.
 */

public abstract class BaseModuleImpl<T> implements IModule {

    protected Bus bus;

    protected Retrofit retrofit;

    protected T api;


    @Inject
    public BaseModuleImpl(Bus bus, Retrofit retrofit) {
        this.bus = bus;
        this.retrofit = retrofit;

        this.createModuleAPI();
    }

    protected abstract void createModuleAPI();
}
