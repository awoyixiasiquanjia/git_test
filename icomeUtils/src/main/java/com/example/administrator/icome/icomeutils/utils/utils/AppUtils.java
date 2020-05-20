package com.example.administrator.icome.icomeutils.utils.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import java.util.List;

public class AppUtils {

    private static int versionCode = -1;

    private static String versionName = "";

    /**
     * 获取meta data
     * @param key key
     * @return String result
     */
    public static String getAppMetaData(Context context,String key) {
        if (TextUtils.isEmpty(key)) {
            return null;
        }
        String resultData = null;
        try {
            PackageManager packageManager =context.getPackageManager();
            if (packageManager != null) {
                ApplicationInfo info = packageManager.getApplicationInfo(
                        context.getPackageName(), PackageManager.GET_META_DATA);
                if ((info != null) && (info.metaData != null)) {
                    if (info.metaData.containsKey(key)){
                        Object obj = info.metaData.get(key);
                        if (obj != null){
                            resultData = obj.toString();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultData;
    }


    /**
     * 获取VersionName,VersionCode
     */
    private static void getAppVersionInfo(Context context) {
        String name = "";
        int code = -1;
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            name = pi.versionName;
            code = pi.versionCode;
            if (TextUtils.isEmpty(name)) {
                name = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        versionName = name;
        versionCode = code;
    }

    public static int getVersionCode(Context context) {
        if (versionCode < 0) {
            getAppVersionInfo(context);
        }
        return versionCode;
    }

    public static String getVersionName(Context context) {
        if (TextUtils.isEmpty(versionName)) {
            getAppVersionInfo(context);
        }
        return versionName;
    }

    /**
     *判断当前应用程序处于前台还是后台
     */
    public static boolean isBackground(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(context.getPackageName())) {
                if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_BACKGROUND) {
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * 获取手机型号
     *
     * @return 手机型号
     */
    public static String getSystemModel() {
        return android.os.Build.MODEL;
    }

    /**
     * 获取手机厂商
     *
     * @return 手机厂商
     */
    public static String getDeviceBrand() {
        return android.os.Build.BRAND;
    }

    /**
     * 获取当前手机系统版本号
     *
     * @return 系统版本号
     */
    public static String getSystemVersion() {
        return android.os.Build.VERSION.RELEASE;
    }
}
