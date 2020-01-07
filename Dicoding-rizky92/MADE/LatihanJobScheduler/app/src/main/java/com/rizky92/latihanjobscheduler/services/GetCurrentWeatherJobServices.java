package com.rizky92.latihanjobscheduler.services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.rizky92.latihanjobscheduler.R;

import org.json.JSONObject;

import java.text.DecimalFormat;

import cz.msebera.android.httpclient.Header;

public class GetCurrentWeatherJobServices extends JobService {
    public final String TAG = GetCurrentWeatherJobServices.class.getSimpleName();
//    final String appId = "4fa6200b8a13bf783af96a104086d454";
//    final String cityId = "1629001";

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.d(TAG, "onStartJob() executed!");
        getCurrentWeather(jobParameters);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.d(TAG, "onStopJob() executed!");
        return true;
    }

    private void getCurrentWeather(final JobParameters jobParameters) {
        Log.d(TAG, "getCurrentWeather is running!");

        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        String url = "http://api.openweathermap.org/data/2.5/weather?id=1629001&appid=4fa6200b8a13bf783af96a104086d454";

        Log.e(TAG, "getCurrentWeather " + url);
        asyncHttpClient.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String result = new String(responseBody);
                Log.d(TAG, result);

                try {
                    JSONObject jsonObject = new JSONObject(result);
                    String curWeather = jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
                    String desc = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
                    double tempK = jsonObject.getJSONObject("main").getDouble("temp");

                    double tempC = tempK - 273;
                    String temp = new DecimalFormat("##.##").format(tempC);
                    String title = "Current Weather";
                    String message = curWeather + ", " + desc + " with " + temp + " Celcius";

                    int notifId = 100;

                    showNotification(getApplicationContext(), title, message, notifId);

                    jobFinished(jobParameters, false);
                } catch (Exception e) {
                    jobFinished(jobParameters, true);
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                jobFinished(jobParameters, true);
            }
        });
    }

    private void showNotification(Context context, String title, String message, int notifId) {
        String CHANNEL_ID = "channel_1";
        String CHANNEL_NAME = "Job Scheduler Channel";

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setContentTitle(title)
                .setSmallIcon(R.drawable.ic_replay_30_black_24dp)
                .setContentText(message)
                .setColor(ContextCompat.getColor(context, android.R.color.black))
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                .setSound(alarmSound);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            channel.enableVibration(true);
            channel.setVibrationPattern(new long[]{1000, 1000, 1000, 1000, 1000});

            builder.setChannelId(CHANNEL_ID);

            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }

        Notification notification = builder.build();

        if (notificationManager != null) {
            notificationManager.notify(notifId, notification);
        }
    }
}
