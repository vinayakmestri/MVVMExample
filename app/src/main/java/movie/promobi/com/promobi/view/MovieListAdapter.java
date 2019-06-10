package movie.promobi.com.promobi.view;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import movie.promobi.com.promobi.R;
import movie.promobi.com.promobi.data.local.entity.Movie;

/**
 * Adapter for showing list of movies.
 */
public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieListHolder> {


    Context context;
    private List<Movie> movies;
    private  OnMovieClickListener onMovieClickListener;

    public MovieListAdapter(Context context,OnMovieClickListener onMovieClickListener, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
        this.onMovieClickListener= onMovieClickListener;

    }

    @Override
    public int getItemViewType(int position) {

        return 0;
    }

    @Override
    public MovieListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_movie_single, parent, false);
        return new MovieListHolder(view);
    }

    @Override
    public void onBindViewHolder(final MovieListHolder holder, int position) {
        try {
            holder.title.setText("" + movies.get(position).getDisplayTitle());
            String url = movies.get(position).getMultimedia().getSrc();
            if (url != null) {
                holder.movieImage.setImageURI(Uri.parse(url));
            }
        } catch (Exception e) {

        }
    }

    @Override
    public int getItemCount() {

        return movies.size();
    }

    public class MovieListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title;
        public SimpleDraweeView movieImage;

        public MovieListHolder(View view) {
            super(view);
            view.setOnClickListener(this);

            title = (TextView) view.findViewById(R.id.title);
            movieImage = (SimpleDraweeView) view.findViewById(R.id.movieImage);

        }

        @Override
        public void onClick(View view) {
            if(onMovieClickListener!=null) {
                onMovieClickListener.onMovieSelectedListener(movies.get(getPosition()));
            }
        }
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    public interface OnMovieClickListener {
        void onMovieSelectedListener(Movie movie);
    }

}