package movie.promobi.com.promobi.data.remote;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import movie.promobi.com.promobi.data.local.entity.Movie;

public class MovieResponse {
    @SerializedName("status")
    private String status;
    @SerializedName("copyright")
    private String copyright;
    @SerializedName("has_more")
    private Boolean hasMore;
    @SerializedName("num_results")
    private Integer numResults;
    @SerializedName("results")
    private List<Movie> results = new ArrayList<>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public Integer getNumResults() {
        return numResults;
    }

    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> movies) {
        this.results = movies;
    }
}