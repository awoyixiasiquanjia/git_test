package com.example.administrator.icome.icomeutils.utils.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by dovsnier on 2018/6/26.
 */
public interface IIntentFragmentUtil extends IIntentUtil {

    void readyGoForResult(Activity context, Class mClass, int num);

    void readyGoForResult(Activity context, Class mClass, int num, Bundle b);

    void readyGo(Context context, Class mClass);

    void readyGo(Activity context, Class mClass, Bundle b);
}
