package com.rizky92.latihan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvRes;
    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMove = findViewById(R.id.btn_move);
        Button btnMoveData = findViewById(R.id.btn_move_data);
        Button btnMoveObj = findViewById(R.id.btn_move_obj);
        Button btnDial = findViewById(R.id.btn_move_dial);
        Button btnRes = findViewById(R.id.btn_move_result);

        tvRes = findViewById(R.id.tv_res);

        btnMove.setOnClickListener(this);
        btnMoveData.setOnClickListener(this);
        btnMoveObj.setOnClickListener(this);
        btnDial.setOnClickListener(this);
        btnRes.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_move:
                Intent move = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(move);
                break;

            case R.id.btn_move_data:
                Intent moveData = new Intent(MainActivity.this, MoveWithDataActivity.class);
                moveData.putExtra(MoveWithDataActivity.EXTRA_NAME, "Rizky");
                moveData.putExtra(MoveWithDataActivity.EXTRA_AGE, 20);
                startActivity(moveData);
                break;

            case R.id.btn_move_obj:
                Benda benda = new Benda();

                benda.setNama("Ayam Bakar Goreng");
                benda.setHarga(35000);
                benda.setStok(5);

                Intent moveObj = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                moveObj.putExtra(MoveWithObjectActivity.EXTRA_BENDA, benda);
                startActivity(moveObj);
                break;

            case R.id.btn_move_dial:
                String num = "082131609462";
                Intent moveDial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+num));
                startActivity(moveDial);
                break;

            case R.id.btn_move_result:
                Intent moveRes = new Intent(MainActivity.this, ResultActivity.class);
                startActivityForResult(moveRes, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == ResultActivity.RESULT_CODE) {
            int val = data.getIntExtra(ResultActivity.EXTRA_SELECTED_VALUE, 0);
            tvRes.setText(String.format("Result = %s", val));
        }
    }
}