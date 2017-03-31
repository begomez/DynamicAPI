package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.otto.Bus;

import java.util.List;

import apimodels.ApiErrorModel;
import apimodels.Sample;
import okhttp3.OkHttpClient;
import rest.interfaces.API;
import rest.interfaces.IDataSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by bernatgomez on 23/3/17.
 */

public class RestDataSource implements IDataSource {

    private static final String BASE_URL = "https://git.eclipse.org/r/";

    private final Bus bus;

    private API api;


    public RestDataSource(Bus bus) {
        this.bus = bus;

        this.createAPI();
    }

    public RestDataSource createAPI() {

        Gson converter = new GsonBuilder().setLenient().create();

        Retrofit adapter = new Retrofit.Builder().client(new OkHttpClient()).baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(converter)).build();

        API api = adapter.create(API.class);

        this.api = api;

        return this;
    }

    public void sampleCall() {
        Call<List<Sample>> call =  this.api.sampleCall("status:open");

        call.enqueue(new Callback<List<Sample>>() {
            @Override
            public void onResponse(Call<List<Sample>> call, Response<List<Sample>> response) {
                if (response.isSuccessful()) {
                    bus.post(response.body().get(0));
                }
            }

            @Override
            public void onFailure(Call<List<Sample>> call, Throwable t) {
                bus.post(new ApiErrorModel());
            }
        });
    }

}
