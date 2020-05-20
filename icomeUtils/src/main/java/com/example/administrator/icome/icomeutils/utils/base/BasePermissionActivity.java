package com.example.administrator.icome.icomeutils.utils.base;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import com.tbruyelle.rxpermissions2.RxPermissions;

/**
 * 权限处理base
 * Created by andongwang on 2018/3/1.
 */
public abstract class BasePermissionActivity extends BaseActivity {

    public RxPermissions mRxPermissions;
    private boolean isToSettings = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mRxPermissions = new RxPermissions(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (isToSettings) {
            isToSettings = false;
            requestPermission();
        }
    }

    @Override
    protected void onResume() {
        mRxPermissions = new RxPermissions(this);
        super.onResume();
    }

    /**
     * 请求权限
     */
    protected void requestPermission() {
    }

    /**
     * 发生没有权限等异常时，显示一个提示dialog.
     */
    protected void showExceptionDialog() {
        new AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle("提示")
                .setMessage("该相册需要赋予访问存储的权限，请到“设置”>“应用”>“权限”中配置权限。")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        finish();
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                getAppDetailSettingIntent(BasePermissionActivity.this);
                isToSettings = true;
            }
        }).show();
    }

    /**
     * 跳转到权限设置界面
     */
    private void getAppDetailSettingIntent(Context context) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= 9) {
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", getPackageName(), null));
        } else if (Build.VERSION.SDK_INT <= 8) {
            intent.setAction(Intent.ACTION_VIEW);
            intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
            intent.putExtra("com.android.settings.ApplicationPkgName", getPackageName());
        }
        startActivity(intent);
    }
}
