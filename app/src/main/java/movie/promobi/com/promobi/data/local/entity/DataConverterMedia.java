package movie.promobi.com.promobi.data.local.entity;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;

public class DataConverterMedia {

    @TypeConverter
    public String fromMedia(Multimedia multimedia) {
        if (multimedia == null) {
            return (null);
        }
        Gson gson = new Gson();
        String json = gson.toJson(multimedia, Multimedia.class);
        return json;
    }

    @TypeConverter
    public Multimedia toMedia(String multimediaString) {
        if (multimediaString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Multimedia multimedia = gson.fromJson(multimediaString, Multimedia.class);
        return multimedia;
    }
}