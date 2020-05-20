package com.example.administrator.icome.icomeutils.utils.base;

import android.support.annotation.NonNull;

import com.dvsnier.base.presenter.AbstractBasePresenter;


/**
 * Created by dovsnier on 2018/6/14.
 */
public class BaseFragmentPresenter<T extends BaseFragment> extends AbstractBasePresenter<T> {

    protected T fragment;

    public BaseFragmentPresenter() {
    }

    public BaseFragmentPresenter(@NonNull T fragment) {
        //noinspection ConstantConditions
        super(null != fragment ? fragment.getActivity() : null);
        this.fragment = fragment;
    }

    @Deprecated
    public T getFragment() {
        return fragment;
    }

    public void setFragment(T fragment) {
        this.fragment = fragment;
        this.context = null != fragment ? fragment.getActivity() : null;
    }

    public T getView() {
        return fragment;
    }

    public void setView(T view) {
        this.fragment = view;
        this.context = null != fragment ? fragment.getActivity() : null;
    }
}
