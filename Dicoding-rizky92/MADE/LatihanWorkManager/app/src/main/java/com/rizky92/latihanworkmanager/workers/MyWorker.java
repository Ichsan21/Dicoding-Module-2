package com.rizky92.latihanworkmanager.workers;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.SyncHttpClient;
import com.rizky92.latihanworkmanager.R;

import org.json.JSONObject;

import java.text.DecimalFormat;

import cz.msebera.android.httpclient.Header;

public class MyWorker extends Worker {

    private static final String TAG = MyWorker.class.getSimpleName();
    private static final String APP_ID = "4fa6200b8a13bf783af96a104086d454";
    public static final String EXTRA_CITY = "city";

    private static final int NOTIFICATION_ID = 1;
    private static final String CHANNEL_ID = "channel_01";
    private static final String CHANNEL_NAME = "asdf92_channel";

    private Result status;

    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        String city = getInputData().getString(EXTRA_CITY);
        Result status = getCurrentWeather(city);
        return status;
    }

    private Result getCurrentWeather(final String city) {
        Log.d(TAG, "getCurrentWeather: Starting...");
        SyncHttpClient client = new SyncHttpClient();
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + APP_ID;
        Log.d(TAG, "getCurrentWeather: API URL is " + url);
        client.post(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String result = new String(responseBody);
                Log.d(TAG, result);
                try {
                    JSONObject object = new JSONObject(result);

                    String curWeather = object.getJSONArray("weather").getJSONObject(0).getString("main");
                    String desc = object.getJSONArray("weather").getJSONObject(0).getString("description");
                    double tempK = object.getJSONObject("main").getDouble("temp");

                    double tempC = tempK - 273;
                    String temp = new DecimalFormat("##.##").format(tempC);
                    String title = "Current Weather";
                    String message = curWeather + ", " + desc + " with " + temp + " Celcius";

                    showNotification(title, message);

                    Log.d(TAG, "getCurrentWeather.onSuccess: Finished!");
                    status = Result.success();
                } catch (Exception e) {
                    showNotification("Get Current Weather failed", e.getMessage());
                    Log.d(TAG, "getCurrentWeather.onSuccess: Failed!");
                    e.printStackTrace();
                    status = Result.failure();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                showNotification("Get Current Weather failed", error.getMessage());
                Log.d(TAG, "getCurrentWeather.onSuccess: Failed!");
                status = Result.failure();
            }
        });
        return status;
    }

    private void showNotification(String title, String message) {
        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
            builder.setChannelId(CHANNEL_ID);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }

        if (notificationManager != null) {
            notificationManager.notify(NOTIFICATION_ID, builder.build());
        }
    }
}
