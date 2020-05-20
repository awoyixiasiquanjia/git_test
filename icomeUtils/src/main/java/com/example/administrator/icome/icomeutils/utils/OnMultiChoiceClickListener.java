package com.example.administrator.icome.icomeutils.utils;

import android.view.View;

/**
 * Dialog 点击事件接口
 * Created by dovsnier on 2018/7/16.
 */
public interface OnMultiChoiceClickListener {

    /**
     * The identifier for the positive button.
     */
    int BUTTON_POSITIVE = -1;

    /**
     * The identifier for the negative button.
     */
    int BUTTON_NEGATIVE = -2;

    void onClick(View dialog, int which);
}
