package com.rizky92.madedicodingsubmission1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    private final Context context;
    private ArrayList<Movies> movies = new ArrayList<>();

    Adapter(Context context) {
        this.context = context;
    }

    public void setMovies(ArrayList<Movies> movies) {
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_movies, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        Movies movies = (Movies) getItem(i);
        viewHolder.bind(movies);

        return itemView;
    }

    private class ViewHolder {
        private TextView tvTitle, tvDesc;
        private ImageView ivPoster;

        ViewHolder(View view) {
            tvTitle = view.findViewById(R.id.tv_title);
            tvDesc = view.findViewById(R.id.tv_desc);
            ivPoster = view.findViewById(R.id.iv_poster);
        }

        void bind(Movies movies) {
            tvTitle.setText(movies.getTitle());
            tvDesc.setText(movies.getDesc());

            // Glide menggantikan setImageResource untuk loading image lebih cepat
            Glide.with(context).load(movies.getFoto()).into(ivPoster);
        }
    }
}
