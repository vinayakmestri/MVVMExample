package movie.promobi.com.promobi.view;

import android.app.Activity;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import movie.promobi.com.promobi.R;
import movie.promobi.com.promobi.data.local.entity.Movie;
import movie.promobi.com.promobi.data.remote.Status;
import movie.promobi.com.promobi.di.MovieViewModel;
import movie.promobi.com.promobi.util.ProgressBarHandler;

public class HomeActivity extends AppCompatActivity implements LifecycleOwner, HasActivityInjector {


    List<Movie> movies = new ArrayList<>();

    MovieViewModel viewModel;

    @Inject
    ViewModelProvider.Factory factory;

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;


    @BindView(R.id.movieListRecyclerView)
    RecyclerView movieListRecyclerView;

    MovieListAdapter movieListAdapter;

    ProgressBarHandler progressBarHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        AndroidInjection.inject(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        progressBarHandler = new ProgressBarHandler(this);
        movieListRecyclerView = findViewById(R.id.movieListRecyclerView);
        movieListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        movieListAdapter = new MovieListAdapter(this, movies);
        movieListRecyclerView.setAdapter(movieListAdapter);

        init();

    }

    void init() {
        viewModel = ViewModelProviders.of(this, factory).get(MovieViewModel.class);

        if (viewModel != null) {
            viewModel.getMovies("").observe(this, listResource -> {
                //Toast.makeText(this, "Yess", Toast.LENGTH_SHORT).show();
                if (listResource.data != null) {
                    viewModel.getStatus().setValue(Status.SUCCESS);
                    movieListAdapter.setMovies(listResource.data);
                }
            });

            viewModel.getStatus().observe(this, status -> {
                switch (status) {
                    case SUCCESS:
                        progressBarHandler.hide();
                        break;
                    case ERROR:
                        progressBarHandler.hide();
                        break;
                    case LOADING:
                        progressBarHandler.show();
                        break;
                    case IDEAL:
                        progressBarHandler.hide();
                        break;
                    default:
                        progressBarHandler.hide();
                        break;

                }
            });
        } else {
            Toast.makeText(this, "View Model not initialized", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
