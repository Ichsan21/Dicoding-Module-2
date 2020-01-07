package com.example.inirecyclerviewv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.inirecyclerviewv2.adapter.CardViewPahlawanAdapter;
import com.example.inirecyclerviewv2.adapter.GridPahlawanAdapter;
import com.example.inirecyclerviewv2.adapter.ListPahlawanAdapter;
import com.example.inirecyclerviewv2.model.DataPahlawan;
import com.example.inirecyclerviewv2.model.Pahlawan;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvPahlawan;
    private ArrayList<Pahlawan> list = new ArrayList<>();
    private String title = "List View";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPahlawan = findViewById(R.id.rv_pahlawan);
        rvPahlawan.setHasFixedSize(true);

        list.addAll(DataPahlawan.getListData());
        showRecycleList();
    }

    private void showSelectedPahlawan(Pahlawan pahlawan) {
        Toast.makeText(this, "Kamu memilih " + pahlawan.getNama(), Toast.LENGTH_SHORT).show();
    }

    private void showRecycleList() {
        rvPahlawan.setLayoutManager(new LinearLayoutManager(this));
        ListPahlawanAdapter listPahlawanAdapter = new ListPahlawanAdapter(list);
        rvPahlawan.setAdapter(listPahlawanAdapter);
        setActionBarTitle(title);

        listPahlawanAdapter.setOnItemClickCallback(new ListPahlawanAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Pahlawan data) {
                showSelectedPahlawan(data);
            }
        });
    }

    private void showRecycleGrid() {
        rvPahlawan.setLayoutManager(new GridLayoutManager(this, 2));
        GridPahlawanAdapter gridPahlawanAdapter = new GridPahlawanAdapter(list);
        rvPahlawan.setAdapter(gridPahlawanAdapter);
        setActionBarTitle(title);

        gridPahlawanAdapter.setOnItemClickCallback(new GridPahlawanAdapter.OnItemClickCallback() {
            @Override
            public void OnItemClicked(Pahlawan data) {
                showSelectedPahlawan(data);
            }
        });
    }

    private void showRecycleCardView() {
        rvPahlawan.setLayoutManager(new LinearLayoutManager(this));
        CardViewPahlawanAdapter cardViewPahlawanAdapter = new CardViewPahlawanAdapter(list);
        rvPahlawan.setAdapter(cardViewPahlawanAdapter);
        setActionBarTitle(title);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:
                title = "List View";
                showRecycleList();
                break;

            case R.id.action_grid:
                title = "Grid View";
                showRecycleGrid();
                break;

            case R.id.action_cardview:
                title = "Card View";
                showRecycleCardView();
                break;
        }
    }
}
