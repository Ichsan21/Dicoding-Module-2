package com.rizky92.latihanbroadcast;

import android.app.Activity;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;

public class PermissionManager {
    public static void check(Activity activity, String string, int requestCode) {
        if (ActivityCompat.checkSelfPermission(activity, string) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[] {string}, requestCode);
        }
    }
}
