package movie.promobi.com.promobi.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import movie.promobi.com.promobi.data.local.MovieDatabase;
import movie.promobi.com.promobi.data.local.dao.MovieDao;
import movie.promobi.com.promobi.data.remote.ApiInterface;
import movie.promobi.com.promobi.repository.MovieRepository;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Admin on 6/5/2019.
 */
@Module(includes = ViewModelModule.class)
public class AppModule {

    @Singleton
    @Provides
    public Gson provideGson() {
        return new GsonBuilder()
                .setLenient()
                .create();
    }

    @Singleton
    @Provides
    public OkHttpClient provideOkHttp() {
        return new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    @Singleton
    @Provides
    public ApiInterface provideApiInterface(OkHttpClient okHttpClient, Gson gson, String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
        return retrofit.create(ApiInterface.class);
    }

    @Singleton
    @Provides
    public String provideBaseUrl() {
        return "https://api.nytimes.com/svc/movies/v2/reviews/";
    }

    @Provides
    @Singleton
    public MovieDatabase provideMovieDatabase(Application application) {
        return Room.databaseBuilder(application, MovieDatabase.class,"movie").build();
    }

    @Provides
    @Singleton
    public MovieDao provideMovieDao(MovieDatabase movieDatabase) {
        return movieDatabase.movieDao();
    }

    @Provides
    @Singleton
    public MovieRepository provideMovieRepository(MovieDao movieDao, ApiInterface apiInterface) {
        return new MovieRepository(movieDao, apiInterface);
    }


}
