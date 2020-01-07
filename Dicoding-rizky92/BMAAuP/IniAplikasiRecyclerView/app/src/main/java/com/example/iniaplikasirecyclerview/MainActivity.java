package com.example.iniaplikasirecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvPahlawan;
    private ArrayList<Pahlawan> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPahlawan = findViewById(R.id.rv_pahlawan);
        rvPahlawan.setHasFixedSize(true);

        list.addAll(DataPahlawan.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvPahlawan.setLayoutManager(new LinearLayoutManager(this));
        ListPahlawanAdapter listPahlawanAdapter = new ListPahlawanAdapter(list);
        rvPahlawan.setAdapter(listPahlawanAdapter);
    }
}

//TODO: Perbaiki layout
//TODO: Lanjut materi dicoding:RecyclerView
