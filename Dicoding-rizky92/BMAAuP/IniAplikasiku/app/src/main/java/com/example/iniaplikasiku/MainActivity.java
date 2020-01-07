package com.example.iniaplikasiku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //deklarasi untuk menampung view
    private EditText editWidth, editHeight, editLength;
    private Button btnCalculate;
    private TextView tvResult;

    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ditampung viewnya
        editHeight = findViewById(R.id.edit_height);
        editWidth = findViewById(R.id.edit_width);
        editLength = findViewById(R.id.edit_length);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        btnCalculate.setOnClickListener(this);

        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(result);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvResult.getText().toString());
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_calculate) {
            String inputLength = editLength.getText().toString().trim();
            String inputWidth = editWidth.getText().toString().trim();
            String inputHeight = editHeight.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputLength)) {
                isEmptyFields = true;
                editLength.setError("Required");
            }

            if (TextUtils.isEmpty(inputWidth)) {
                isEmptyFields = true;
                editWidth.setError("Required");
            }

            if (TextUtils.isEmpty(inputHeight)) {
                isEmptyFields = true;
                editHeight.setError("Required");
            }

            Double l = toDouble(inputLength);
            Double w = toDouble(inputWidth);
            Double h = toDouble(inputHeight);

            if (l == null) {
                isInvalidDouble = true;
                editLength.setError("Must be numeric");
            }

            if (w == null) {
                isInvalidDouble = true;
                editWidth.setError("Must be numeric");
            }

            if (h == null) {
                isInvalidDouble = true;
                editHeight.setError("Must be numeric");
            }

            if (!isEmptyFields && !isInvalidDouble) {
                double Volume = l*w*h;
                tvResult.setText(String.valueOf(Volume));
            }
        }
    }

    private Double toDouble(String str) {
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }


}
