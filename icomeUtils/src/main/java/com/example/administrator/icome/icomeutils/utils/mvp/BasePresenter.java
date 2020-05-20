package com.example.administrator.icome.icomeutils.utils.mvp;

import android.content.Context;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author xlq
 * persenter基类
 */
public abstract class BasePresenter<V extends BaseView, M extends BaseModel> {
    protected CompositeDisposable disposables = new CompositeDisposable();
    protected V mView;
    protected M model;
    protected String TAG;
    protected Context context;
    public BasePresenter(V view,Context context) {
        attachView(view);
        this.context=context;
        model = initModel();
        TAG = getClass().getSimpleName();
    }

    public void attachView(V view) {
        mView = view;
        this.model = initModel();
    }

    public void detachView() {

        disposables.clear();
        mView = null;
    }

    public abstract M initModel();


    public V getView() {
        return mView;
    }

    protected void addDisposable(Disposable d){
        disposables.add(d);
    }
}
