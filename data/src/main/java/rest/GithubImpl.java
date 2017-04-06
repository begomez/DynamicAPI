package rest;

import com.myapps.utils.LoggerUtils;
import com.squareup.otto.Bus;

import java.util.List;

import javax.inject.Inject;

import apimodels.ApiErrorModel;
import apimodels.Sample;
import rest.interfaces.IAPIModule;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by bernatgomez on 6/4/17.
 */

public class GithubImpl extends BaseImpl<GithubImpl.IGithub> {

    private static final String TAG = GithubImpl.class.getSimpleName();

    @Inject
    public GithubImpl(Bus bus, Retrofit retrofit) {
        super(bus, retrofit);
    }

    @Override
    protected void createAPI() {
        this.api = retrofit.create(IGithub.class);
    }

    public void sampleCall(String status) {

        this.api.sampleCall(status)
            .subscribeOn(Schedulers.newThread())
            .observeOn(Schedulers.immediate())
            .subscribe(new Subscriber<List<Sample>>() {
                @Override
                public void onCompleted() {
                    LoggerUtils.logMsg(TAG, "onCompleted()");
                }

                @Override
                public void onError(Throwable e) {
                    LoggerUtils.logMsg(TAG, "onError()");

                    bus.post(new ApiErrorModel());
                }

                @Override
                public void onNext(List<Sample> samples) {
                    LoggerUtils.logMsg(TAG, "onNext()");

                    bus.post(samples.get(0));
                }
            }
        );

    }

    public interface IGithub {

        @GET("changes/")
        public Observable<List<Sample>> sampleCall(@Query("q") String status);
    }
}
