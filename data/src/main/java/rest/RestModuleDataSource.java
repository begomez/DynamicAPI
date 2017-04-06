package rest;

import com.squareup.otto.Bus;

import javax.inject.Inject;

import rest.interfaces.IDataSource;
import retrofit2.Retrofit;

/**
 * Created by bernatgomez on 23/3/17.
 */

public class RestModuleDataSource implements IDataSource {

    private final Bus bus;

    private Retrofit retrofit;

    private GithubModuleImpl github;

    @Inject
    public RestModuleDataSource(Bus bus, Retrofit retrofit) {
        this.bus = bus;

        this.retrofit = retrofit;

        this.github = new GithubModuleImpl(bus, retrofit);
    }

    public void sampleCall() {
        this.github.sampleCall("status:open");
    }

}
