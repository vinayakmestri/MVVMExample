package movie.promobi.com.promobi.data.local.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "movie")
public class Movie {

    @PrimaryKey(autoGenerate = true)
    public Long id;
    @SerializedName("display_title")
    private String displayTitle;
    @SerializedName("mpaa_rating")
    private String mpaaRating;
    @SerializedName("critics_pick")
    private Integer criticsPick;
    @SerializedName("byline")
    private String byline;
    @SerializedName("headline")
    private String headline;
    @SerializedName("summary_short")
    private String summaryShort;
    @SerializedName("privateation_date")
    private String privateationDate;
    @SerializedName("opening_date")
    private String openingDate;
    @SerializedName("date_updated")
    private String dateUpdated;
    //@SerializedName("link")
    //private Link link;
    @TypeConverters(DataConverter.class)
    @SerializedName("multimedia")
    private Multimedia multimedia = null;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisplayTitle() {
        return displayTitle;
    }

    public void setDisplayTitle(String displayTitle) {
        this.displayTitle = displayTitle;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public Integer getCriticsPick() {
        return criticsPick;
    }

    public void setCriticsPick(Integer criticsPick) {
        this.criticsPick = criticsPick;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getSummaryShort() {
        return summaryShort;
    }

    public void setSummaryShort(String summaryShort) {
        this.summaryShort = summaryShort;
    }

    public String getPrivateationDate() {
        return privateationDate;
    }

    public void setPrivateationDate(String privateationDate) {
        this.privateationDate = privateationDate;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    /* public Link getLink() {
         return link;
     }

     public void setLink(Link link) {
         this.link = link;
     }
 */
    public Multimedia getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(Multimedia multimedia) {
        this.multimedia = multimedia;
    }

}