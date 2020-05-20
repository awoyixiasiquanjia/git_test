package com.example.administrator.icome.icomeutils.utils.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;

public class Router {
    private String scheme = "ennicome://";
    private String host = "www.router.com";
    private String port = "8080";

    private static Router instance;
    public static final String TAG = Router.class.getSimpleName();
    private Router() {
    }

    public static Router getInstance() {
        if (instance == null) {
            instance = new Router();
        }
        return instance;
    }

    /**
     * 创建隐式跳转Intent
     * @param context
     * @param path
     * @return
     */
    public void startActivity(@NonNull Activity context, @NonNull String path) {
        port = AppUtils.getAppMetaData(context,"port");
        if (null != context && (!TextUtils.isEmpty(path)) && (!TextUtils.isEmpty(port))) {
            Intent intent = new Intent();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(scheme).append(host).append(":").append(port).append("/").append(path);
            intent.setData(Uri.parse(stringBuilder.toString()));
            context.startActivity(intent);
        }
    }

    public String getScheme() {
        return scheme;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

}
