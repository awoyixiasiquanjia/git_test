package com.example.administrator.icome.icomeutils.utils.base;

import android.support.annotation.NonNull;

import com.dvsnier.base.presenter.AbstractBasePresenter;

/**
 * Created by dovsnier on 2018/6/14.
 */
public class BasePresenter<T extends BaseActivity> extends AbstractBasePresenter<T> {

    protected T activity;

    public BasePresenter() {
    }

    public BasePresenter(@NonNull T activity) {
        super(activity);
        this.activity = activity;
    }

    @Deprecated
    public T getActivity() {
        return activity;
    }

    public void setActivity(T activity) {
        this.activity = activity;
        this.context = activity;
    }

    public T getView() {
        return activity;
    }

    public void setView(T view) {
        this.activity = view;
        this.context = activity;
    }
}
