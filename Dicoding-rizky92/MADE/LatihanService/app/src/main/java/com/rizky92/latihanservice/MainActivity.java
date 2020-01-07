package com.rizky92.latihanservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnStartService, btnStartIntentService, btnStartBoundService, btnStopBoundService;
    Intent intent;
    boolean boolServiceBound = false;
    MyBoundService boundService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartService = findViewById(R.id.btn_start_service);
        btnStartService.setOnClickListener(this);

        btnStartIntentService = findViewById(R.id.btn_start_intent_service);
        btnStartIntentService.setOnClickListener(this);

        btnStartBoundService = findViewById(R.id.btn_start_bound_service);
        btnStartBoundService.setOnClickListener(this);

        btnStopBoundService = findViewById(R.id.btn_stop_bound_service);
        btnStopBoundService.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start_service:
                intent = new Intent(MainActivity.this, MyService.class);
                startService(intent);
                break;

            case R.id.btn_start_intent_service:
                intent = new Intent(MainActivity.this, MyIntentService.class);
                intent.putExtra(MyIntentService.EXTRA_DURATION, 5000L);
                startService(intent);
                break;

            case R.id.btn_start_bound_service:
                intent = new Intent(MainActivity.this, MyBoundService.class);
                bindService(intent, serviceConnection, BIND_AUTO_CREATE);
                break;

            case R.id.btn_stop_bound_service:
                unbindService(serviceConnection);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (boolServiceBound) {
            unbindService(serviceConnection);
        }
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyBoundService.MyBinder binder = (MyBoundService.MyBinder) iBinder;
            boundService = binder.getService();
            boolServiceBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            boolServiceBound = false;
        }
    };
}
