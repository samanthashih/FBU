package com.example.flixster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.flixster.R;
import com.example.flixster.models.Movie;
import org.parceler.Parcels;

public class MovieDetailsActivity extends AppCompatActivity {

    Movie movie;

    //view object fields
    TextView tvTitle;
    RatingBar rbVoteAverage;
    TextView tvOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        //set view object fields
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        rbVoteAverage = (RatingBar) findViewById((R.id.rbVoteAverage));
        tvOverview = (TextView) findViewById(R.id.tvOverview);

        //unwrap movie passed in by intent, the simple name = key
        movie = (Movie) Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));
        Log.d("MovieDetailsActivity", String.format("Showing details for '%s'", movie.getTitle()));

        // set title and overview w/ movie stuff
        tvTitle.setText(movie.getTitle());
        tvOverview.setText(movie.getOverview());

        // vote avg og /10 stars, divide by 2 to get /5 stars
        float voteAverage = movie.getVoteAverage().floatValue() / 2.0f;
        rbVoteAverage.setRating(voteAverage);


    }
}