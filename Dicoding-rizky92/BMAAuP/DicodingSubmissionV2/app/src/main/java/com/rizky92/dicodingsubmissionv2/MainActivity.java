package com.rizky92.dicodingsubmissionv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.rizky92.dicodingsubmissionv2.model.DataHape;
import com.rizky92.dicodingsubmissionv2.model.Hape;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Hape> list = new ArrayList<>();
    private String title = "Dicoding Submission";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_xiaomi);
        recyclerView.setHasFixedSize(true);

        list.addAll(DataHape.getListData());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RowAdapter RowAdapter = new RowAdapter(list);
        recyclerView.setAdapter(RowAdapter);
        setActionBar(title);
    }

    private void setActionBar(String title) {
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about) {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
