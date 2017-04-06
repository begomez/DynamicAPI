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

    private static final String BASE_URL = "https://git.eclipse.org/r/";

    private final Bus bus;

    private API api;


    @Inject
    public RestDataSource(Bus bus, API api) {
        this.bus = bus;

        this.api = api;
    }

    public void sampleCall() {
        this.api.sampleCall("status:open")
            .subscribeOn(Schedulers.newThread())
            .observeOn(Schedulers.immediate())
            .subscribe(new Subscriber<List<Sample>>() {
                @Override
                public void onCompleted() {
                    Logger.getAnonymousLogger().log(Level.INFO, "onCompleted()");
                }

                @Override
                public void onError(Throwable e) {
                    Logger.getAnonymousLogger().log(Level.INFO, "onError()");

                    bus.post(new ApiErrorModel());
                }

                @Override
                public void onNext(List<Sample> samples) {
                    Logger.getAnonymousLogger().log(Level.INFO, "onNext()");
                    bus.post(samples.get(0));
                }
            });




    }

}
