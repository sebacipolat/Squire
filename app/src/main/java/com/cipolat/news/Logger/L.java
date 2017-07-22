package com.cipolat.news.Logger;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import com.cipolat.news.BuildConfig;

import java.util.List;

/**
 * Created by sebastian on 10/10/16.
 */

public class L {

    public static void v(String TAG, String message) {
        if(isDebug())
            Log.v(TAG, attachThread(message));

    }

    public static void d(String TAG, String message) {
        if(isDebug())
            Log.v(TAG, attachThread(message));
    }

    public static void e(String TAG, String message) {
        if(isDebug())
            Log.e(TAG, attachThread(message));
    }

    private static String attachThread(String str) {
        return Thread.currentThread().getId() + " " + str;
    }

    private static boolean isDebug() {
        if (BuildConfig.DEBUG) {
            return true;
        } else
            return false;
    }

    private boolean isAppIsInBackground(Context context) {
        boolean isInBackground = true;
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT_WATCH) {
            List<ActivityManager.RunningAppProcessInfo> runningProcesses = am.getRunningAppProcesses();
            for (ActivityManager.RunningAppProcessInfo processInfo : runningProcesses) {
                if (processInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                    for (String activeProcess : processInfo.pkgList) {
                        if (activeProcess.equals(context.getPackageName())) {
                            isInBackground = false;
                        }
                    }
                }
            }
        } else {
            List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);
            ComponentName componentInfo = taskInfo.get(0).topActivity;
            if (componentInfo.getPackageName().equals(context.getPackageName())) {
                isInBackground = false;
            }
        }

        return isInBackground;
    }
}

