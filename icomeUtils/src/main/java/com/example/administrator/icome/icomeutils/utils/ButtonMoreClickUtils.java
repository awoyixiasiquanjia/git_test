package com.example.administrator.icome.icomeutils.utils;

/**
 * Created by lishuai on 2019/2/21.
 * 多次点击的限制
 */

public class ButtonMoreClickUtils {
    private static final int MIN_DELAY_TIME = 1500;  // 两次点击间隔不能少于1500ms
    private static long lastClickTime;

    public static boolean isMoreClick() {
        boolean isClick = true;
        long currentTimeMillis = System.currentTimeMillis();
        if ((currentTimeMillis - lastClickTime) >= MIN_DELAY_TIME) {
            isClick = false;
        }
        lastClickTime = currentTimeMillis;
        return isClick;
    }
}
