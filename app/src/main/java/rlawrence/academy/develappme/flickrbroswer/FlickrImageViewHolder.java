package rlawrence.academy.develappme.flickrbroswer;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Raquel Lawrence on 10/29/15.
 */
public class FlickrImageViewHolder extends RecyclerView.ViewHolder
{

    protected ImageView thumbnail;
    protected TextView title;

    public FlickrImageViewHolder(View view) {
        super(view);
        this.thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        this.title = (TextView) view.findViewById(R.id.title);

    }
}
