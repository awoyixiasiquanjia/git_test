package com.example.administrator.icome.icomeutils.utils;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by dovsnier on 2018/6/14.
 */
public class UiThreadUtil implements IUiThread {

    private static final UiThreadUtil INSTANCE = new UiThreadUtil();

    public static UiThreadUtil getInstance() {
        return INSTANCE;
    }

    private UiThreadUtil() {
    }

    @Override
    public boolean isUIThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    @Override
    public void runUiThread(@NonNull Context context, Runnable runnable) {
        //noinspection ConstantConditions
        if (null == context || null == runnable) {
            return;
        }
        if (context instanceof AppCompatActivity) {
            if (!((AppCompatActivity) context).isDestroyed()) {
                if (isUIThread()) {
                    runnable.run();
                } else {
                    ((AppCompatActivity) context).runOnUiThread(runnable);
                }
            }
        }
    }

    @Override
    public void runUiThread(@NonNull Context context, Runnable runnable, long delayMillis) {
        //noinspection ConstantConditions
        if (null == context || null == runnable || delayMillis < 0) {
            return;
        }
        if (context instanceof AppCompatActivity) {
            if (!((AppCompatActivity) context).isDestroyed()) {
                ((AppCompatActivity) context).getWindow().getDecorView().postDelayed(runnable, delayMillis);
            }
        }
    }
}
