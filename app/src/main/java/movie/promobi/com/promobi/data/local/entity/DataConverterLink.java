package movie.promobi.com.promobi.data.local.entity;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;

public class DataConverterLink {

    @TypeConverter
    public String fromLink(Link multimedia) {
        if (multimedia == null) {
            return (null);
        }
        Gson gson = new Gson();
        String json = gson.toJson(multimedia, Link.class);
        return json;
    }

    @TypeConverter
    public Link toMedia(String multimediaString) {
        if (multimediaString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Link likMedia = gson.fromJson(multimediaString, Link.class);
        return likMedia;
    }
 }