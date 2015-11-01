package rlawrence.academy.develappme.flickrbroswer;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


/**
 * Created by Raquel Lawrence on 10/29/15.
 * Purpose: This class creates an instance of a toolbar
 * to be displayed on the main screen of the application
 */
public class BaseActivity extends AppCompatActivity
{
    private Toolbar mToolbar;
    public static final String FLICKR_QUERY = "FLICKR_QUERY";
    public static final String PHOTO_TRANSFER = "PHOTO_TRANSFER";

    protected Toolbar activateToolbar()
    {
        if(mToolbar == null)
        {
            mToolbar = (Toolbar) findViewById(R.id.app_bar);

            if(mToolbar != null)
            {
                setSupportActionBar( mToolbar);
            }
        }

        return mToolbar;
    }

    protected Toolbar activateToolbarWithHomeEnabled()
    {
        activateToolbar();
        if(mToolbar != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        return mToolbar;
    }

}
