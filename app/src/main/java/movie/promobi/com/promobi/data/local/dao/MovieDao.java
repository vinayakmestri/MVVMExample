package movie.promobi.com.promobi.data.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import movie.promobi.com.promobi.data.local.entity.Movie;

/**
 * Created by Vinayak on 6/5/2019.
 * Used for ROOM database operations
 */
@Dao
public interface MovieDao {
    @Query("SELECT * FROM movie")
    LiveData<List<Movie>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Movie movie);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Movie> movies);

    @Query("DELETE FROM movie")
    void deleteAll();

    @Query("SELECT COUNT(*) FROM movie")
    int getCount();
}
