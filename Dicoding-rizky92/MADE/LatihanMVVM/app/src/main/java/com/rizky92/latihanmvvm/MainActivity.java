package com.rizky92.latihanmvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MainViewModel mainViewModel;

    private EditText etWidth, etHeight, etLength;
    private TextView tvRes;
    private Button btnCalVol, btnCalCirc, btnCalSurf, btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new MainViewModel(new CuboidModel());

        etWidth = findViewById(R.id.et_lebar);
        etLength = findViewById(R.id.et_panjang);
        etHeight = findViewById(R.id.et_tinggi);

        tvRes = findViewById(R.id.tv_result);

        btnCalVol = findViewById(R.id.btn_cal_vol);
        btnCalCirc = findViewById(R.id.btn_cal_circ);
        btnCalSurf = findViewById(R.id.btn_cal_surf);
        btnSave = findViewById(R.id.btn_save);

        btnCalVol.setOnClickListener(this);
        btnCalCirc.setOnClickListener(this);
        btnCalSurf.setOnClickListener(this);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String length = etLength.getText().toString().trim();
        String width = etWidth.getText().toString().trim();
        String height = etHeight.getText().toString().trim();

        if (TextUtils.isEmpty(length)) {
            etLength.setError("Field tidak boleh kosong!");
        } else if (TextUtils.isEmpty(height)) {
            etHeight.setError("Field tidak boleh kosong!");
        } else if (TextUtils.isEmpty(width)) {
            etWidth.setError("Field tidak boleh kosong!");
        } else {
            double l = Double.parseDouble(length);
            double w = Double.parseDouble(width);
            double h = Double.parseDouble(height);

            if (view.getId() == R.id.btn_save) {
                mainViewModel.save(l, w, h);
                visible();
            } else if (view.getId() == R.id.btn_cal_circ) {
                tvRes.setText(String.valueOf(mainViewModel.getCircumference()));
                gone();
            } else if (view.getId() == R.id.btn_cal_surf) {
                tvRes.setText(String.valueOf(mainViewModel.getSurfaceArea()));
                gone();
            } else if (view.getId() == R.id.btn_cal_vol) {
                tvRes.setText(String.valueOf(mainViewModel.getVolume()));
                gone();
            }
        }
    }

    private void visible() {
        btnCalSurf.setVisibility(View.VISIBLE);
        btnCalCirc.setVisibility(View.VISIBLE);
        btnCalVol.setVisibility(View.VISIBLE);

        btnSave.setVisibility(View.GONE);
    }

    private void gone() {
        btnCalSurf.setVisibility(View.GONE);
        btnCalCirc.setVisibility(View.GONE);
        btnCalVol.setVisibility(View.GONE);

        btnSave.setVisibility(View.VISIBLE);
    }
}
