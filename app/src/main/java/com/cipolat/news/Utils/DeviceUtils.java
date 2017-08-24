package com.cipolat.news.Utils;

import android.content.Context;
import android.content.res.Configuration;
import android.net.ParseException;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by scipolat on 02/05/16.
 */
public class DeviceUtils {
    public static void LogDeviceInfo(Context ctx) {
        String details = "VERSION.RELEASE : " + Build.VERSION.RELEASE
                + "\nVERSION.INCREMENTAL : " + Build.VERSION.INCREMENTAL
                + "\nVERSION.SDK.NUMBER : " + Build.VERSION.SDK_INT
                + "\nBOARD : " + Build.BOARD
                + "\nBOOTLOADER : " + Build.BOOTLOADER
                + "\nBRAND : " + Build.BRAND
                + "\nCPU_ABI : " + Build.CPU_ABI
                + "\nCPU_ABI2 : " + Build.CPU_ABI2
                + "\nDISPLAY : " + Build.DISPLAY
                + "\nFINGERPRINT : " + Build.FINGERPRINT
                + "\nHARDWARE : " + Build.HARDWARE
                + "\nHOST : " + Build.HOST
                + "\nID : " + Build.ID
                + "\nMANUFACTURER : " + Build.MANUFACTURER
                + "\nMODEL : " + Build.MODEL
                + "\nPRODUCT : " + Build.PRODUCT
                + "\nSERIAL : " + Build.SERIAL
                + "\nTAGS : " + Build.TAGS
                + "\nTIME : " + Build.TIME
                + "\nTYPE : " + Build.TYPE
                + "\nUNKNOWN : " + Build.UNKNOWN
                + "\nUSER : " + Build.USER
                + "\nNETWORK: " + getNetworkType(ctx)
                + "\nTABLET: " + isTablet(ctx)
                + "\nDEVICE INCH: " + getDeviceInch(ctx)
                + "\nPROCESORS NUMBER: " + String.valueOf(Runtime.getRuntime().availableProcessors());

        Log.d("device info", " " + details);
    }

    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    public static int getPhoneOrientation(Context context) {
        return context.getResources().getConfiguration().orientation;
    }

    public static boolean isLandScape(Context context) {
        if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            return true;
        }
        return false;
    }


    public static boolean getDeviceMoreThan5Inch(Context activity) {
        try {
            DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
            // int width = displayMetrics.widthPixels;
            // int height = displayMetrics.heightPixels;

            float yInches = displayMetrics.heightPixels / displayMetrics.ydpi;
            float xInches = displayMetrics.widthPixels / displayMetrics.xdpi;
            double diagonalInches = Math.sqrt(xInches * xInches + yInches * yInches);
            if (diagonalInches >= 7) {
                // 5inch device or bigger
                return true;
            } else {
                // smaller device
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static String getNetworkType(Context activity) {
        String type = "Mobile Data";
        TelephonyManager tm = (TelephonyManager) activity.getSystemService(Context.TELEPHONY_SERVICE);
        switch (tm.getNetworkType()) {
            case TelephonyManager.NETWORK_TYPE_HSDPA:
                type = "Mobile Data 3G";
                Log.d("Type", "3g");
                // for 3g HSDPA networktype will be return as
                // per testing(real) in device with 3g enable
                // data
                // and speed will also matters to decide 3g network type
                break;
            case TelephonyManager.NETWORK_TYPE_HSPAP:
                type = "Mobile Data 4G";
                Log.d("Type", "4g");
                // No specification for the 4g but from wiki
                // i found(HSPAP used in 4g)
                break;
            case TelephonyManager.NETWORK_TYPE_GPRS:
                type = "Mobile Data GPRS";
                Log.d("Type", "GPRS");
                break;
            case TelephonyManager.NETWORK_TYPE_EDGE:
                type = "Mobile Data EDGE 2G";
                Log.d("Type", "EDGE 2g");
                break;

        }
        return type;
    }

    public static String getDeviceInch(Context activity) {
        try {
            DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
            float yInches = displayMetrics.heightPixels / displayMetrics.ydpi;
            float xInches = displayMetrics.widthPixels / displayMetrics.xdpi;
            double diagonalInches = Math.sqrt(xInches * xInches + yInches * yInches);
            return String.valueOf(diagonalInches);
        } catch (Exception e) {
            return "-1";
        }
    }

    //indica si paso cierto tiempo (hs) entre 2 tiempos
    //tiempo deteccion, tiempo actual
    public static boolean isPassedTime(String time1, String time2, int hs) {
        boolean result = false;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        try {
            Date d1 = null, d2 = null;
            long diff = 0;
            try {
                d1 = sdf.parse(time1);
                d2 = sdf.parse(time2);
                diff = d2.getTime() - d1.getTime();
            } catch (Exception e) {
                e.printStackTrace();
            }
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            if (diffHours >= hs)
                result = true;

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }
}
