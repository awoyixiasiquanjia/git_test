package com.example.administrator.icome.icomeutils.utils.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by dovsnier on 2018/6/19.
 */
public class BaseCompatFragment<T extends BaseFragmentPresenter> extends BaseFragment {

    protected String TAG = this.getClass().getSimpleName();
    @Nullable
    protected T presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newInstance();
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
                        if (presenter instanceof BaseFragmentPresenter) {
                            //noinspection RedundantCast,unchecked
                            ((BaseFragmentPresenter) presenter).setFragment(this);
                        } else {
                            // nothing to do
                        }
                    }
                } catch (IllegalAccessException | java.lang.InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Nullable
    public T getPresenter() {
        return presenter;
    }

    public void setPresenter(@Nullable T presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != presenter) {
            presenter.onDestroy();
        }
    }

    public void closeInputMethod() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (null != inputMethodManager) {
                //noinspection ConstantConditions
                inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showInputMethod() {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (null != inputMethodManager) {
            inputMethodManager.showSoftInput(getActivity().getCurrentFocus(), 0);
        }
    }


    public void showInputMethod(@NonNull View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (null != inputMethodManager) {
            inputMethodManager.showSoftInput(view, 0);
        }
    }
}
