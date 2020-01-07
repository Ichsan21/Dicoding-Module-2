package com.rizky92.latihanbroadcast;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SmsReceiverActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvFrom, tvMessage;
    Button btnClose;

    public static final String EXTRA_SMS_NO = "extra_sms_no", EXTRA_SMS_MESSAGE = "extra_sms_message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_receiver);

        tvFrom = findViewById(R.id.tv_from);
        tvMessage = findViewById(R.id.tv_message);
        btnClose = findViewById(R.id.btn_close);
        btnClose.setOnClickListener(this);

        String senderNo = getIntent().getStringExtra(EXTRA_SMS_NO);
        String senderMessage = getIntent().getStringExtra(EXTRA_SMS_MESSAGE);

        tvFrom.setText(String.format("from: %s", senderNo));
        tvMessage.setText(senderMessage);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_close) {
            finish();
        }
    }
}
