package com.example.administrator.icome.icomeutils.utils.base;

import android.os.Bundle;

/**
 * Created by dovsnier on 2018/6/26.
 */
public interface IIntentActivityUtil extends IIntentUtil {

    void readyGo(Class<?> clazz);

    void readyGo(Class<?> clazz, Bundle bundle);

    void readyGoThenKill(Class<?> clazz);

    void readyGoThenKill(Class<?> clazz, Bundle bundle);

    void readyGoForResult(Class<?> clazz, int requestCode);

    void readyGoForResult(Class<?> clazz, int requestCode, Bundle bundle);
}
