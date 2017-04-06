package com.begoandapps.padelapp.dependencies.modules;


import android.os.Build;

import com.begoandapps.padelapp.BuildConfig;
import com.google.firebase.database.Logger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import rest.GithubImpl;
import rest.RestDataSource;
import rest.interfaces.API;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by bernatgomez on 22/3/17.
 */
@Module
public class ApplicationModule {

    @Provides
    @Singleton
    public Bus provideBus() {
        return new Bus(ThreadEnforcer.ANY);
    }

    @Provides
    @Singleton
    public API provideAPI(Retrofit retrofit) {
        return retrofit.create(API.class);
    }

    @Provides
    @Singleton
    public RestDataSource provideRest(Bus bus, API api, Retrofit retrofit) {
        return new RestDataSource(bus, api, retrofit);
    }

    @Provides
    @Singleton
    public OkHttpClient provideHttpClient() {
        final int POOL_SIZE = 1;
        final int TIMEOUT = 30 * 1000;
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            clientBuilder.addInterceptor(interceptor);
        }

        ConnectionPool connectionPool = new ConnectionPool(POOL_SIZE, TIMEOUT, TimeUnit.MILLISECONDS);

        clientBuilder.connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS);

        clientBuilder.readTimeout(TIMEOUT, TimeUnit.MILLISECONDS);

        clientBuilder.retryOnConnectionFailure(false);

        clientBuilder.connectionPool(connectionPool);

        OkHttpClient client = clientBuilder.build();

        return client;
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        final String BASE_URL = "https://git.eclipse.org/r/";

        Retrofit.Builder retroBuilder = new Retrofit.Builder();

        Gson converter = new GsonBuilder().setLenient().create();

        retroBuilder.client(client);

        retroBuilder.baseUrl(BASE_URL);

        retroBuilder.addCallAdapterFactory(RxJavaCallAdapterFactory.create());

        retroBuilder.addConverterFactory(GsonConverterFactory.create(converter));

        Retrofit adapter = retroBuilder.build();

        return adapter;
    }
}
