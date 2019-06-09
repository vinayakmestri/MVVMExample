package movie.promobi.com.promobi.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import movie.promobi.com.promobi.data.local.dao.MovieDao;
import movie.promobi.com.promobi.data.local.entity.Movie;
import movie.promobi.com.promobi.data.remote.ApiInterface;
import movie.promobi.com.promobi.data.remote.MovieResponse;
import movie.promobi.com.promobi.data.remote.NetworkBoundResource;
import movie.promobi.com.promobi.data.remote.Resource;
import movie.promobi.com.promobi.data.remote.Status;
import retrofit2.Call;

/**
 * Created by Vinayak on 6/4/2019.
 */

public class MovieRepository {

    ApiInterface apiInterface;
    MovieDao movieDao;
    MutableLiveData<Status> statusLiveData = new MutableLiveData<>();

    @Inject
    public MovieRepository(MovieDao movieDao, ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
        this.movieDao = movieDao;
    }


    public MutableLiveData<Status> getProgressStatus() {
        return statusLiveData;
    }

    /**
     * This function fetches data from server and return data to MovieViewModel
     */
    public LiveData<Resource<List<Movie>>> fetchMovies(String query) {

        return new NetworkBoundResource<List<Movie>, MovieResponse>() {


            @Override
            protected void saveCallResult(@NonNull MovieResponse item) {
                if (item != null) {
                    if (item.getResults() != null || !item.getResults().isEmpty()) {
                        if (movieDao.getCount() > 0)
                            movieDao.deleteAll();

                        movieDao.insertAll(item.getResults());

                    }
                }
            }

            @NonNull
            @Override
            protected LiveData<List<Movie>> loadFromDb() {
                return movieDao.getAll();
            }

            @Override
            protected void onFetchFailed() {
                super.onFetchFailed();
                statusLiveData.setValue(Status.ERROR);
            }

            @NonNull
            @Override
            protected Call<MovieResponse> createCall() {
                statusLiveData.setValue(Status.LOADING);
                return apiInterface.getMovies("uEJImOonG1HwBZdxL76LTag5NcSxBD1n");
            }
        }.getAsLiveData();

    }
}
