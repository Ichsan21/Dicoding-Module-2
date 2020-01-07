package com.rizky92.latihanworkmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rizky92.latihanworkmanager.workers.MyWorker;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnOneTime, btnStartPeriodic, btnCancelPeriodic;
    TextView tvStatus;
    EditText edtCity;
    private PeriodicWorkRequest workRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOneTime = findViewById(R.id.btn_one_time);
        btnStartPeriodic = findViewById(R.id.btn_start_periodic);
        btnCancelPeriodic = findViewById(R.id.btn_cancel_periodic);
        tvStatus = findViewById(R.id.tv_status);
        edtCity = findViewById(R.id.edt_city);

        btnOneTime.setOnClickListener(this);
        btnStartPeriodic.setOnClickListener(this);
        btnCancelPeriodic.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_one_time:
                startOneTimeTask();
                break;

            case R.id.btn_start_periodic:
                startPeriodicTask();
                break;

            case R.id.btn_cancel_periodic:
                stopPeriodicTask();
                break;
        }
    }

    private void startOneTimeTask() {
        tvStatus.setText(getString(R.string.status));

        Data data = new Data.Builder()
                .putString(MyWorker.EXTRA_CITY, edtCity.getText().toString())
                .build();

        OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest.Builder(MyWorker.class)
                .setInputData(data)
                .build();

        WorkManager.getInstance().enqueue(oneTimeWorkRequest);

        WorkManager.getInstance().getWorkInfoByIdLiveData(oneTimeWorkRequest.getId()).observe(MainActivity.this, new Observer<WorkInfo>() {
            @Override
            public void onChanged(WorkInfo workInfo) {
                String status = workInfo.getState().name();
                tvStatus.append("\n" + status);
            }
        });
    }

    private void startPeriodicTask() {
        tvStatus.setText(getString(R.string.status));

        Data data = new Data.Builder()
                .putString(MyWorker.EXTRA_CITY, edtCity.getText().toString())
                .build();

        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build();

        workRequest = new PeriodicWorkRequest.Builder(MyWorker.class, 15, TimeUnit.MINUTES)
                .setInputData(data)
                .setConstraints(constraints)
                .build();

        WorkManager.getInstance().enqueue(workRequest);

        WorkManager.getInstance().getWorkInfoByIdLiveData(workRequest.getId()).observe(MainActivity.this, new Observer<WorkInfo>() {
            @Override
            public void onChanged(WorkInfo workInfo) {
                String status = workInfo.getState().name();
                tvStatus.append("\n" + status);
                btnCancelPeriodic.setEnabled(false);
                if (workInfo.getState() == WorkInfo.State.ENQUEUED) {
                    btnCancelPeriodic.setEnabled(true);
                }
            }
        });
    }

    private void stopPeriodicTask() {
        WorkManager.getInstance().cancelWorkById(workRequest.getId());
    }
}
