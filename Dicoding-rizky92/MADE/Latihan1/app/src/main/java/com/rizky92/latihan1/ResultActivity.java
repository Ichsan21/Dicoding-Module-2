package com.rizky92.latihan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnChoose;
    private RadioGroup rgNum;

    public static final String EXTRA_SELECTED_VALUE= "extra_selected_value";
    public static final int RESULT_CODE = 110;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btnChoose = findViewById(R.id.choose);
        rgNum = findViewById(R.id.rg_num);

        btnChoose.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.choose) {
            if (rgNum.getCheckedRadioButtonId() != 0) {
                int val = 0;
                switch(rgNum.getCheckedRadioButtonId()) {
                    case R.id.val_1:
                        val = 50;
                        break;

                    case R.id.val_2:
                        val = 100;
                        break;

                    case R.id.val_3:
                        val = 200;
                        break;

                    case R.id.val_4:
                        val = 400;
                        break;
                }
                Intent result = new Intent();
                result.putExtra(EXTRA_SELECTED_VALUE, val);
                setResult(RESULT_CODE, result);
                finish();
            }
        }
    }
}
