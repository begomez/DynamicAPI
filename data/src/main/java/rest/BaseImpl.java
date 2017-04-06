package rest;

import com.squareup.otto.Bus;

import javax.inject.Inject;

import rest.interfaces.IAPIModule;
import retrofit2.Retrofit;

/**
 * Created by bernatgomez on 6/4/17.
 */

public abstract class BaseImpl<T extends IAPIModule> {

    protected Bus bus;

    protected Retrofit retrofit;

    protected T api;

    @Inject
    public BaseImpl(Bus bus, Retrofit retrofit) {
        this.bus = bus;
        this.retrofit = retrofit;

    }

    protected abstract void createAPI();

}
