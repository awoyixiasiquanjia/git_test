package com.example.administrator.icome.icomeutils.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;

import com.example.administrator.icome.icomeutils.utils.utils.AppUtils;

/**
 * @author wangye
 * @description: 引导浮层工具类
 * @date :2019/8/27 6:44 PM
 */
public class GuidedFloatingUtils {

    private static final String userId = "userId";

    /**
     * 初始化浮层
     *
     * @param context
     * @param dialog2Listener
     * @param firstResourceId
     */
    public static void initguide(Context context, String idKey, String versionKey, MyNewDialog.Dialog2Listener dialog2Listener, int firstResourceId) {
        String workbenchVersion = SharedPreferencesUtils.getStringShareData(context, versionKey);

        if (TextUtils.isEmpty(workbenchVersion) || workbenchVersion == null || !workbenchVersion.equals(AppUtils.getVersionName(context))) {
            SharedPreferencesUtils.putStringShareData(context, versionKey, AppUtils.getVersionName(context));
            floatingLayer(context, idKey, dialog2Listener, firstResourceId);
        } else {
            String workflow = SharedPreferencesUtils.getStringShareData(context, idKey);
            if (TextUtils.isEmpty(workflow) || workflow == null || !workflow.equals(SharedPreferencesUtils.getStringShareData(context, userId))) {
                floatingLayer(context, idKey, dialog2Listener, firstResourceId);
            }
        }
    }

    /**
     * 弹出浮层
     */
    private static void floatingLayer(Context context, String idKey, MyNewDialog.Dialog2Listener dialog2Listener, int firstResourceId) {
        SharedPreferencesUtils.putStringShareData(context, idKey, SharedPreferencesUtils.getStringShareData(context, userId));
        new MyNewDialog().guideDialog((Activity) context, dialog2Listener, firstResourceId,true);//替换新图
    }


    /**initWorkBenchGuide
     * 初始化工作台引导浮层
     * @param context
     * @param idKey
     * @param versionKey
     * @param newDialogListener
     * @param imageId
     */
    public static void initWorkBenchGuide(Context context, String idKey, String versionKey, MyNewDialog.newDialogListener newDialogListener, int imageId) {
        String workbenchVersion = SharedPreferencesUtils.getStringShareData(context, versionKey);

        if (TextUtils.isEmpty(workbenchVersion) || workbenchVersion == null || !workbenchVersion.equals(AppUtils.getVersionName(context))) {
            SharedPreferencesUtils.putStringShareData(context, versionKey, AppUtils.getVersionName(context));
            workBenchFloatView(context, idKey, newDialogListener, imageId);
        } else {
            String workflow = SharedPreferencesUtils.getStringShareData(context, idKey);
            if (TextUtils.isEmpty(workflow) || workflow == null || !workflow.equals(SharedPreferencesUtils.getStringShareData(context, userId))) {
                workBenchFloatView(context, idKey, newDialogListener, imageId);
            }
        }
    }


    /**
     * 弹出工作台引导浮层
     * @param context
     * @param idKey
     * @param newDialogListener
     * @param imageId
     */
    private static void workBenchFloatView(Context context, String idKey, MyNewDialog.newDialogListener newDialogListener, int imageId) {
        SharedPreferencesUtils.putStringShareData(context, idKey, SharedPreferencesUtils.getStringShareData(context, userId));
        new MyNewDialog().workBenchGuideDialog((Activity) context, newDialogListener, imageId,true); //替换新图
    }
}
