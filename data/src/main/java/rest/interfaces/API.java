package rest.interfaces;

import java.util.List;

import apimodels.ApiSessionModel;
import apimodels.Sample;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by bernatgomez on 29/3/17.
 */

public interface API {


    @GET("changes/")
    public Observable<List<Sample>> sampleCall(@Query("q") String q);

}
