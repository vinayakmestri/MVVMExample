package movie.promobi.com.promobi.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import movie.promobi.com.promobi.R;
import movie.promobi.com.promobi.data.local.entity.Movie;

public class MovieInformation extends FragmentActivity {


    Movie movie;

    @BindView(R.id.movieName)
    TextView movieName;

    @BindView(R.id.rating)
    TextView rating;

    @BindView(R.id.movieDescription)
    TextView movieDescription;

    @BindView(R.id.movieDate)
    TextView movieDate;

    @BindView(R.id.moviePublishDate)
    TextView moviePublishDate;

    @BindView(R.id.movieHeading)
    TextView movieHeading;

    @BindView(R.id.articleLink)
    TextView articleLink;

    @BindView(R.id.movieImage)
    SimpleDraweeView movieImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_information);
        ButterKnife.bind(this);

        movie = (Movie) getIntent().getSerializableExtra("object");

        movieName.setText(movie.getDisplayTitle());
        movieDescription.setText(movie.getSummaryShort());
        rating.setText((movie.getMpaaRating() == null || movie.getMpaaRating().isEmpty()) ? "No rating" : movie.getMpaaRating());
        movieDate.setText((movie.getOpeningDate() == null ? "Not available" : movie.getOpeningDate()));
        moviePublishDate.setText((movie.getPublication_date() == null ? "Not available" : movie.getPublication_date()));
        movieHeading.setText(movie.getHeadline());
        articleLink.setText((movie.getLink().getSuggestedLinkText() == null) ? "" : Html.fromHtml("<u>"+movie.getLink().getSuggestedLinkText()+"</u>"));
        movieImage.setImageURI(Uri.parse(movie.getMultimedia().getSrc()));

    }

    @OnClick({R.id.articleLink, R.id.bookButton})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.articleLink:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(movie.getLink().getUrl()));
                startActivity(browserIntent);
                break;
            case R.id.bookButton:
                Toast.makeText(this, "Thank you", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
