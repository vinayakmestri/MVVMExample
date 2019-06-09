package movie.promobi.com.promobi.data.local.entity;

import android.arch.persistence.room.Entity;

import com.google.gson.annotations.SerializedName;

@Entity
public class Link {

    @SerializedName("type")
    private String type;
    @SerializedName("url")
    private String url;
    @SerializedName("suggested_link_text")
    private String suggestedLinkText;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSuggestedLinkText() {
        return suggestedLinkText;
    }

    public void setSuggestedLinkText(String suggestedLinkText) {
        this.suggestedLinkText = suggestedLinkText;
    }
}