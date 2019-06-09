package movie.promobi.com.promobi.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import movie.promobi.com.promobi.data.local.entity.Movie;
import movie.promobi.com.promobi.data.local.dao.MovieDao;

/**
 * Created by Vinayak on 6/5/2019.
 */

@Database(entities = {Movie.class}, version = 2,exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase {
    public abstract MovieDao movieDao();
}
