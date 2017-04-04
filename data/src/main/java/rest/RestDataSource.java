package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.otto.Bus;

import java.util.List;

import javax.inject.Inject;

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


    @Inject
    public RestDataSource(Bus bus, API api) {
        this.bus = bus;

        this.api = api;
    }

    public void sampleCall() {
        Call<List<Sample>> call =  this.api.sampleCall("status:open");

        call.enqueue(new Callback<List<Sample>>() {
            @Override
            public void onResponse(Call<List<Sample>> call, Response<List<Sample>> response) {
                if (response.isSuccessful()) {
                    this.bus.post(response.body().get(0));
                }
            }

            @Override
            public void onFailure(Call<List<Sample>> call, Throwable t) {
                this.bus.post(new ApiErrorModel());
            }
        });
    }

}
