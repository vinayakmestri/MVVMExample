package movie.promobi.com.promobi.di;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import movie.promobi.com.promobi.data.local.entity.Movie;
import movie.promobi.com.promobi.data.remote.Resource;
import movie.promobi.com.promobi.data.remote.Status;
import movie.promobi.com.promobi.repository.MovieRepository;

/**
 * Created by Vinayak on 6/4/2019.
 */

public class MovieViewModel extends ViewModel {

    private LiveData<Resource<List<Movie>>> movies ;
    private MutableLiveData<Status> status ;
    MovieRepository movieRepository;
    @Inject
    public MovieViewModel(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public MutableLiveData<Status> getStatus(){
        return movieRepository.getProgressStatus();
    }

    public LiveData<Resource<List<Movie>>> getMovies(String query) {
        movies = movieRepository.fetchMovies("");
        return movies;
    }
}
