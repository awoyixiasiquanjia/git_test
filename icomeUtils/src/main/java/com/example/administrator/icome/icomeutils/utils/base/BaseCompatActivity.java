package com.example.administrator.icome.icomeutils.utils.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.dvsnier.base.view.IBaseView;

import org.json.JSONException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by dovsnier on 2018/6/15.
 */
public abstract class BaseCompatActivity<T extends BasePresenter> extends BaseActivity implements IBaseView {

    protected String TAG = this.getClass().getSimpleName();
    @Nullable
    protected T presenter;

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected void initViewsAndEvents() throws JSONException {
        newInstance();
        initView();
        initData();
    }

    private void newInstance() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        //noinspection PointlessNullCheck
        if (null != genericSuperclass && genericSuperclass instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType) genericSuperclass;
            //noinspection unchecked
            Class<T> clazz = (Class<T>) type.getActualTypeArguments()[0];
            if (null != clazz) {
                try {
                    presenter = clazz.newInstance();
                    if (null != presenter) {
                        //noinspection ConstantConditions
                        if (presenter instanceof BasePresenter) {
                            //noinspection unchecked
                            ((BasePresenter) presenter).setActivity(this);
                        } else {
                            // nothing to do
                        }
                    }
                } catch (IllegalAccessException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void initData() {



    }

    @Nullable
    public T getPresenter() {
        return presenter;
    }

    public void setPresenter(@Nullable T presenter) {
        this.presenter = presenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != presenter) {
            presenter.onDestroy();
        }
    }

    public void closeInputMethod() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (null != inputMethodManager) {
                //noinspection ConstantConditions
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showInputMethod() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (null != inputMethodManager) {
            inputMethodManager.showSoftInput(getCurrentFocus(), 0);
        }
    }


    public void showInputMethod(@NonNull View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (null != inputMethodManager) {
            inputMethodManager.showSoftInput(view, 0);
        }
    }
}
