package com.rizky92.dicodingsubmissionv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import de.hdodenhof.circleimageview.CircleImageView;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Button btnOke = findViewById(R.id.button);
        btnOke.setOnClickListener(this);

        CircleImageView circleImageView = findViewById(R.id.profile);
        circleImageView.setImageDrawable(getResources().getDrawable(R.drawable.le));
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button) {
            Intent backToMain = new Intent(AboutActivity.this, MainActivity.class);
            startActivity(backToMain);
        }
    }
}
