package com.team420.kekterm.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

public class PermissionCheck {
    private static final String TAG = "PermissionCheck";
    public static final int DEFAULT_PERMISSION_RQCODE = 1;

    public static final String[] DEFAULT_PERMISSIONS = {
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    //First check the permissions everytime the app is freshly run.
    public static void checkPermissions(Context context, Activity activity, String[] PERMISSIONS, int REQUEST_CODE) {
        if (!hasPermissions(context, PERMISSIONS)) {
            ActivityCompat.requestPermissions(activity, PERMISSIONS, REQUEST_CODE);
        }
    }

    private static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isAllPermitted(Context context, String[] PERMISSIONS){
        for (String permissions:PERMISSIONS){
            if (ActivityCompat.checkSelfPermission(context, permissions) != PackageManager.PERMISSION_GRANTED){
                Log.e(TAG, "Permissions are NOT all granted.");
                return false;
            }
        }
        Log.d(TAG, "All permissions are granted.");
        return true;
    }

}
