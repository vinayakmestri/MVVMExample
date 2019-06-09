package movie.promobi.com.promobi.data.remote;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Atul on 1/24/2017.
 */

public interface ApiInterface {

    @GET("search.json")
    Call<MovieResponse> getMovies(@Query("api-key") String key);

}