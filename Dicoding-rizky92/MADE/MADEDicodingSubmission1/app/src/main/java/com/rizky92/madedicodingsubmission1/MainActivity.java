package com.rizky92.madedicodingsubmission1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Adapter adapter;
    private ArrayList<Movies> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = findViewById(R.id.lv_movies);
        adapter = new Adapter(this);
        listView.setAdapter(adapter);

        list.addAll(Data.getListData());

        adapter.setMovies(list);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                Movies movies = (Movies) adapter.getItem(i);
                intent.putExtra(DetailActivity.EXTRA_MOVIES, movies);
                startActivity(intent);
            }
        });
    }
}
