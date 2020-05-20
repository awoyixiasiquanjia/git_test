package com.example.administrator.icome.icomeutils.utils;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by dovsnier on 2018/6/14.
 */
public interface IUiThread {

    boolean isUIThread();

    void runUiThread(@NonNull Context context, Runnable runnable);

    void runUiThread(@NonNull Context context, Runnable runnable, long delayMillis);
}
