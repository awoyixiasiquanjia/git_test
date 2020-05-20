package com.example.administrator.icome.icomeutils.utils.base;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import com.example.administrator.icome.icomeutils.utils.mvp.BasePresenter ;
/**
 * Created by Administrator on 2017/10/31.
 * fragment基类
 */

public class BaseFragment<T extends BasePresenter> extends Fragment implements IIntentFragmentUtil,IIntentUtil {
    protected T presenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter=createPresenter();
    }


    @Override
    public void readyGoForResult(Activity context, Class mClass, int num) {
        Intent intent = new Intent(context, mClass);
        startActivityForResult(intent, num);
    }

    @Override
    public void readyGoForResult(Activity context, Class mClass, int num, Bundle b) {
        Intent intent = new Intent(context, mClass);
        intent.putExtras(b);
        startActivityForResult(intent, num);
    }

    @Override
    public void readyGo(Context context, Class mClass) {
        Intent intent = new Intent(context, mClass);
        startActivity(intent);
    }

    @Override
    public void readyGo(Activity context, Class mClass, Bundle b) {
        Intent intent = new Intent(context, mClass);
        intent.putExtras(b);
        startActivity(intent);
    }


    protected  T createPresenter(){
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
            presenter.detachView();
        }
    }

}
