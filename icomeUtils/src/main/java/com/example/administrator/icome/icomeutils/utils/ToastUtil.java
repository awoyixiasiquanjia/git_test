package com.example.administrator.icome.icomeutils.utils;

import android.content.Context;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.icome.icomeutils.R;


/**
 * @author by Lilong on 18/1/10
 */
public class ToastUtil {
    private static String oldMsg;
    protected static Toast toast = null;
    private static long oneTime = 0;
    private static long twoTime = 0;

//    public static void showToast(Context context, String s) {
//        if (toast == null) {
//            toast = Toast.makeText(context.getApplicationContext(), s, Toast.LENGTH_SHORT);
//            toast.show();
//            oneTime = System.currentTimeMillis();
//        } else {
//            twoTime = System.currentTimeMillis();
//            if (s.equals(oldMsg)) {
//                if (twoTime - oneTime > Toast.LENGTH_SHORT) {
//                    toast.show();
//                }
//            } else {
//                oldMsg = s;
//                toast.setText(s);
//                toast.show();
//            }
//        }
//        oneTime = twoTime;
//    }

    public static void showToast(Context context, int resId) {
        showToast(context.getApplicationContext(), context.getString(resId));
    }

    protected static Toast centerToast = null;

    /**
     * 居中显示Toast
     *
     * @param context
     * @param resId
     * @param time    显示时长
     */
    public static View showCenterToast(Context context, int resId, long time) {
        View view = LayoutInflater.from(context).inflate(resId, null);
//        if (centerToast!= null) {
//            centerToast.cancel();
//
//        }else {
        centerToast = Toast.makeText(context.getApplicationContext(), "", Toast.LENGTH_SHORT);
        centerToast.setGravity(Gravity.CENTER, 0, 0);
//        }
        centerToast.setView(view);
        centerToast.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                centerToast.cancel();
            }
        }, time);
        return view;
    }

    /**
     * 资源居中显示Toast
     *
     * @param context
     * @param text
     */
    public static void showToast(Context context, String text) {
        View view = LayoutInflater.from(context).inflate(R.layout.toast_black_layout, null);
        TextView textView = view.findViewById(R.id.toast_black_text);

        textView.setText(text);

        centerToast = Toast.makeText(context.getApplicationContext(), "", Toast.LENGTH_SHORT);
        centerToast.setGravity(Gravity.CENTER, 0, 0);

        centerToast.setView(view);
        centerToast.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                centerToast.cancel();
            }
        }, 1500);//显示时长
    }

    /**
     * 底部显示Toast
     *
     * @param context
     * @param text
     */
    public static void showBottomToast(Context context, String text) {
        View view = LayoutInflater.from(context).inflate(R.layout.toast_black_layout, null);
        TextView textView = view.findViewById(R.id.toast_black_text);

        textView.setText(text);

        centerToast = Toast.makeText(context.getApplicationContext(), "", Toast.LENGTH_SHORT);
        centerToast.setGravity(Gravity.BOTTOM, 0, 150);

        centerToast.setView(view);
        centerToast.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                centerToast.cancel();
            }
        }, 3000);//显示时长
    }


}
