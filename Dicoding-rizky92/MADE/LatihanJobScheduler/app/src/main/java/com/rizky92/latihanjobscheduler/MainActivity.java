package com.rizky92.latihanjobscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rizky92.latihanjobscheduler.services.GetCurrentWeatherJobServices;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnStart, btnStop;
    private int jobId = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btn_start);
        btnStop = findViewById(R.id.btn_stop);

        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                startJob();
                break;

            case R.id.btn_stop:
                stopJob();
                break;
        }
    }

    private void startJob() {
        if (isJobRunning(this)) {
            Toast.makeText(this, "Job service is already scheduled", Toast.LENGTH_SHORT).show();
            return;
        }

        ComponentName serviceComponent = new ComponentName(this, GetCurrentWeatherJobServices.class);
        JobInfo.Builder builder = new JobInfo.Builder(jobId, serviceComponent);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        builder.setRequiresDeviceIdle(false);
        builder.setRequiresCharging(false);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            builder.setPeriodic(90000);
        } else {
            builder.setPeriodic(18000);
        }

        JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        jobScheduler.schedule(builder.build());

        Toast.makeText(this, "Job service started!", Toast.LENGTH_SHORT).show();
    }

    private void stopJob() {
        JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        jobScheduler.cancel(jobId);
        Toast.makeText(this, "Job service stopped", Toast.LENGTH_SHORT).show();
        finish();
    }

    private boolean isJobRunning(Context context) {
        boolean isScheduled = false;

        JobScheduler scheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);

        if (scheduler != null) {
            for (JobInfo jobInfo : scheduler.getAllPendingJobs()) {
                if (jobInfo.getId() == jobId) {
                    isScheduled = true;
                    break;
                }
            }
        }

        return isScheduled;
    }
}
