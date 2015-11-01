package rlawrence.academy.develappme.flickrbroswer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Raquel Lawrence on 10/29/15.
 */
public class FlickrRecyclerViewAdapter extends RecyclerView.Adapter<FlickrImageViewHolder>
{
    private List<Photo> mphotoList;
    private Context mContext;
    private final String LOG_TAG = FlickrRecyclerViewAdapter.class.getSimpleName();

    public FlickrRecyclerViewAdapter(Context context, List<Photo> photosList)
    {
        this.mContext = context;
        this.mphotoList = photosList;
    }

    @Override
    public FlickrImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.browse, null);
        FlickrImageViewHolder flickrImageViewHolder = new FlickrImageViewHolder(view);
        return flickrImageViewHolder;
    }

    /**
     * Uses the picasso library to download image to the thumbnail
     * placeholder. Downloads images needed to show on the screen
     * @param flickrImageViewHolder
     */
    @Override
    public void onBindViewHolder(FlickrImageViewHolder flickrImageViewHolder, int i)
    {
        Photo photoItem = mphotoList.get(i);
        Log.d(LOG_TAG, "Processing: " + photoItem.getTitle() + " --> " + Integer.toString(i));

        Picasso.with(mContext).load(photoItem.getImage()) //download this image
                .error(R.drawable.placeholder) // if error show this image
                .placeholder(R.drawable.placeholder) // show while downloading
                .into(flickrImageViewHolder.thumbnail); // puts into ImageView in XML
        flickrImageViewHolder.title.setText(photoItem.getTitle());
    }

    @Override
    public int getItemCount() {
        return (null != mphotoList ? mphotoList.size() : 0);
    }

    public void loadNewData(List<Photo> newPhotos)
    {
        mphotoList = newPhotos;
        notifyDataSetChanged();
    }

    public Photo getPhoto(int position)
    {
        return (null != mphotoList ? mphotoList.get(position) : null);
    }
}
