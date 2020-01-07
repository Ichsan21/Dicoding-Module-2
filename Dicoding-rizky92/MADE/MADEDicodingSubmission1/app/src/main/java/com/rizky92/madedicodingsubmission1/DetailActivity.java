package com.rizky92.madedicodingsubmission1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIES = "extra_movies";

    private TextView tvTitle, tvDesc, tvDate, tvLength, tvRating;
    private ImageView ivPoster;
    private Button btnTrailer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTitle = findViewById(R.id.tv_title);
        tvDesc = findViewById(R.id.tv_desc);
        tvDate = findViewById(R.id.tv_date);
        tvLength = findViewById(R.id.tv_length);
        tvRating = findViewById(R.id.tv_rating);
        btnTrailer = findViewById(R.id.btn_trailer);
        ivPoster = findViewById(R.id.iv_poster);

        final Movies movies = getIntent().getParcelableExtra(EXTRA_MOVIES);

        tvTitle.setText(movies.getTitle());
        tvDesc.setText(movies.getDesc());
        tvDate.setText(movies.getDate());
        tvLength.setText(movies.getLength());
        tvRating.setText(movies.getRating());

        btnTrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent yt = new Intent(Intent.ACTION_VIEW, Uri.parse(movies.getUrl()));
                startActivity(yt);
            }
        });

        Glide.with(this).load(movies.getFoto()).into(ivPoster);
    }
}
