package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;

import apimodels.ApiErrorModel;
import apimodels.Sample;
import okhttp3.OkHttpClient;
import okhttp3.internal.tls.AndroidTrustRootIndex;
import rest.interfaces.API;
import rest.interfaces.IDataSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by bernatgomez on 23/3/17.
 */

public class RestDataSource implements IDataSource {

    private final Bus bus;

    private Retrofit retrofit;

    private GithubImpl github;

    @Inject
    public RestDataSource(Bus bus, Retrofit retrofit) {
        this.bus = bus;

        this.retrofit = retrofit;

        this.github = new GithubImpl(bus, retrofit);
    }

    public void sampleCall() {
        this.github.sampleCall("status:open");
    }

}
