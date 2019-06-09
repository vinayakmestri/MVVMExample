package movie.promobi.com.promobi.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import movie.promobi.com.promobi.R;


/**
 * Created by Atul on 2/7/2017.
 */

public class ProgressBarHandler {

    private ProgressBar mProgressBar;
    private Context mContext;
    private RelativeLayout rl;
    private ViewGroup layout;

    public ProgressBarHandler(Context context) {
        mContext = context;

        layout = (ViewGroup) ((Activity) context).findViewById(android.R.id.content).getRootView();

        mProgressBar = new ProgressBar(context, null, android.R.attr.progressBarStyleLarge);
        mProgressBar.setIndeterminate(true);

        RelativeLayout.LayoutParams params = new
                RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);

        rl = new RelativeLayout(context);


        rl.setGravity(Gravity.CENTER);

        // Set the progress bar color

        mProgressBar.getIndeterminateDrawable().setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.MULTIPLY);
        rl.addView(mProgressBar);
        layout.addView(rl, params);

        hide();
    }

    public void show() {
        layout.setOnTouchListener(null);
        rl.setBackgroundColor(mContext.getResources().getColor(android.R.color.holo_green_light));
        mProgressBar.setVisibility(View.VISIBLE);
    }

    public void hide() {
        rl.setBackgroundColor(mContext.getResources().getColor(android.R.color.transparent));
        if (mProgressBar.getVisibility() == View.VISIBLE) {
            mProgressBar.setVisibility(View.INVISIBLE);
        }
    }

}
