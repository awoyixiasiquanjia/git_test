package com.example.administrator.icome.icomeutils.utils;

import android.app.AppOpsManager;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.ImageView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Calendar;

/**
 * Created by Muzik
 * 2018/12/20 10:17
 */
public class NotificationUtil {
    private OnNextLitener mOnNextLitener;

    //判断该app是否打开了通知

    //判断是否需要打开设置界面
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void OpenNotificationSetting(Context context, OnNextLitener mOnNextLitener) {
        if (!isNotificationEnabled(context)) {
            if (isNoToday(context)){
                showSettingDialog(context, mOnNextLitener);
            }
        } else {
            if (mOnNextLitener != null) {
                mOnNextLitener.onNext();
            }
        }
    }

    //打开手机设置页面

    /**
     * 可以通过NotificationManagerCompat 中的 areNotificationsEnabled()来判断是否开启通知权限。NotificationManagerCompat 在 android.support.v4.app包中，是API 22.1.0 中加入的。而 areNotificationsEnabled()则是在 API 24.1.0之后加入的。
     * areNotificationsEnabled 只对 API 19 及以上版本有效，低于API 19 会一直返回true
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static boolean isNotificationEnabled(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
            boolean areNotificationsEnabled = notificationManagerCompat.areNotificationsEnabled();
            return areNotificationsEnabled;
        }

        String CHECK_OP_NO_THROW = "checkOpNoThrow";
        String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";

        AppOpsManager mAppOps = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
        ApplicationInfo appInfo = context.getApplicationInfo();
        String pkg = context.getApplicationContext().getPackageName();
        int uid = appInfo.uid;

        Class appOpsClass = null;
        /* Context.APP_OPS_MANAGER */
        try {
            appOpsClass = Class.forName(AppOpsManager.class.getName());
            Method checkOpNoThrowMethod = appOpsClass.getMethod(CHECK_OP_NO_THROW, Integer.TYPE, Integer.TYPE,
                    String.class);
            Field opPostNotificationValue = appOpsClass.getDeclaredField(OP_POST_NOTIFICATION);
            int value = (Integer) opPostNotificationValue.get(Integer.class);
            return ((Integer) checkOpNoThrowMethod.invoke(mAppOps, value, uid, pkg) == AppOpsManager.MODE_ALLOWED);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    /**
     * 假设没有开启通知权限，点击之后就需要跳转到 APP的通知设置界面，对应的Action是：Settings.ACTION_APP_NOTIFICATION_SETTINGS, 这个Action是 API 26 后增加的
     * 如果在部分手机中无法精确的跳转到 APP对应的通知设置界面，那么我们就考虑直接跳转到 APP信息界面，对应的Action是：Settings.ACTION_APPLICATION_DETAILS_SETTINGS
     */
    private static void gotoSet(Context context) {

        Intent intent = new Intent();
        if (Build.VERSION.SDK_INT >= 26) {
            // android 8.0引导
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
        } else if (Build.VERSION.SDK_INT >= 21) {
            // android 5.0-7.0
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("app_package", context.getPackageName());
            intent.putExtra("app_uid", context.getApplicationInfo().uid);
        } else {
            // 其他
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        }
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    static void showSettingDialog(final Context mContext, final OnNextLitener mOnNextLitener) {
        //提示弹窗
        new MyNewDialog().isNotificationEnabled(mContext, new MyNewDialog.Dialog2Listener() {
            @Override
            public void leftOnclick() {
                if (mOnNextLitener != null) {
                    mOnNextLitener.onButtonClick();
                }
            }

            @Override
            public void rightOnclick() {
                gotoSet(mContext);
                if (mOnNextLitener != null) {
                    mOnNextLitener.onButtonClick();
                }
            }

            @Override
            public void rightOnclick(String edit) {

            }

            @Override
            public void guideOnclick(ImageView imageView, Dialog mdialog) {

            }

            @Override
            public void dismiss() {

            }
        });
    }

    private static  boolean isNoToday(Context context) {
        String today = SharedPreferencesUtils.getStringShareData(context, "isToday");
        Calendar calendar = Calendar.getInstance();
        //年
        int year = calendar.get(Calendar.YEAR);
        //月
        int month = calendar.get(Calendar.MONTH) + 1;
        //日
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        String time = year+"年"+month+"月"+day+"日";

        if (null != today && !today.equals("")){
            //如果日期相等就不弹
            if (today.equals(time)){
                return false;
            }else {
                SharedPreferencesUtils.putStringShareData(context,"isToday",time);
                return true;
            }
        } else {
            SharedPreferencesUtils.putStringShareData(context,"isToday",time);
            return true;
        }
    }

    public void setOnNextLitener(OnNextLitener mOnNextLitener) {
        this.mOnNextLitener = mOnNextLitener;
    }

    /**
     * 清除当前应用所有通知
     */
    public static void cancelAll(Context context){
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancelAll();
    }
    /*=====================添加Listener回调================================*/
    public interface OnNextLitener {
        /**
         * 不需要设置通知的下一步
         */
        void onNext();

        void onButtonClick();
    }

}