package rest.interfaces;

import apimodels.ApiSessionModel;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by bernatgomez on 29/3/17.
 */

public interface API {

    @POST
    public Observable<ApiSessionModel> login(@Body String user, @Body String pass);

    @POST
    public Observable<Boolean> logout(@Body ApiSessionModel session);

}
