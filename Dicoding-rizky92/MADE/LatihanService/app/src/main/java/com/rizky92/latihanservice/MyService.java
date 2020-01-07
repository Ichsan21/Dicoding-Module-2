package com.rizky92.latihanservice;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

import java.lang.ref.WeakReference;

import static android.content.ContentValues.TAG;

public class MyService extends Service implements DummyAsyncCallBack {

    private static final String TAG = MyService.class.getSimpleName();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");

        DummyAsync dummyAsync = new DummyAsync(this);
        dummyAsync.execute();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void preAsync() {
        Log.d(TAG, "preAsync: Begin...");
    }

    @Override
    public void postAsync() {
        Log.d(TAG, "postAsync: Finish...");
        stopSelf();
    }

    private class DummyAsync extends AsyncTask<Void, Void, Void> {

        private final WeakReference<DummyAsyncCallBack> callBackWeakReference;

        DummyAsync(DummyAsyncCallBack callBack) {
            this.callBackWeakReference = new WeakReference<>(callBack);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d(TAG, "onPreExecute: ");
            callBackWeakReference.get().preAsync();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Log.d(TAG, "doInBackground: ");
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d(TAG, "onPostExecute");
            callBackWeakReference.get().postAsync();
        }
    }
}

interface DummyAsyncCallBack {
    void preAsync();
    void postAsync();
}
