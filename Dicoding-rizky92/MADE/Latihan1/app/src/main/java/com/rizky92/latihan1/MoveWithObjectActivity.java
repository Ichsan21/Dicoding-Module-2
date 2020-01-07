package com.rizky92.latihan1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveWithObjectActivity extends AppCompatActivity {
    public static final String EXTRA_BENDA = "extra_benda";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        TextView tvObj = findViewById(R.id.tv_obj);

        Benda benda = getIntent().getParcelableExtra(EXTRA_BENDA);
        String text = "Nama barang = " + benda.getNama() + "\nHarga barang = " + benda.getHarga() + "\nJumlah Stok = " + benda.getStok();
        tvObj.setText(text);
    }
}
