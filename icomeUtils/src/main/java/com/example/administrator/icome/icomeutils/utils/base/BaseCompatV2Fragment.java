package com.example.administrator.icome.icomeutils.utils.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.example.administrator.icome.icomeutils.utils.mvp.BasePresenter ;
/**
 * Created by Administrator on 2017/10/31.
 * fragment基类
 */
public class BaseCompatV2Fragment<T extends BasePresenter> extends BaseFragment {

    @Nullable
    protected T presenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = createPresenter();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != presenter) {
            presenter.detachView();
        }
    }

    protected T createPresenter() {
        return null;
    }

    @Nullable
    public T getPresenter() {
        return presenter;
    }
}
