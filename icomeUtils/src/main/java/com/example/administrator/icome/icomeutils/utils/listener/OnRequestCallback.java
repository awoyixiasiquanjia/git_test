package com.example.administrator.icome.icomeutils.utils.listener;

import io.reactivex.disposables.Disposable;

public abstract class OnRequestCallback<T> {
    /**
     * 网络连接不可用
     */
    public void onNetNotWork() {

    }

    /**
     * 请求开始时调用
     */
    public void onRequestStart(Disposable d) {
    }

    /**
     * 请求结束时调用
     */
    public void onRequestEnd() {
    }

    /**
     * 请求成功但code码错误时调用
     *
     * @throws Exception
     */
    public void onCodeError(String message) throws Exception {
    }

    /**
     * 请求成功
     *
     * @throws Exception
     */
    public abstract void onSuccess(T t) throws Exception;


    /**
     * 缓存请求成功
     *
     * @throws Exception
     */
    public void onCacheSuccess(T t) throws Exception {
    }


    /**
     * 请求失败时调用
     *
     * @param e
     * @param isNetWorkError 是否是网络错误
     * @throws Exception
     */
    public abstract void onFailure(Throwable e, boolean isNetWorkError) throws Exception;
}
