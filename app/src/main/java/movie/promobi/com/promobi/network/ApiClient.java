package movie.promobi.com.promobi.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import movie.promobi.com.promobi.data.remote.ApiInterface;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Atul on 1/24/2017.
 */

public class ApiClient {

    public static final String BASE_URL = "https://api.nytimes.com/svc/movies/v2/reviews/";

    static ApiInterface REST_CLIENT;

    static {
        setupRestClient();
    }

    public static ApiInterface get() {
        return REST_CLIENT;
    }


    private static void setupRestClient() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        REST_CLIENT = retrofit.create(ApiInterface.class);

    }


}
