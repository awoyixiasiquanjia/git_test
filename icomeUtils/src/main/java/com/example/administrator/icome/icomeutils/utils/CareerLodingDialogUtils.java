package com.example.administrator.icome.icomeutils.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.icome.icomeutils.R;


public class CareerLodingDialogUtils {

    private static NewGifView spaceshipImage;

    /**
     * 显示Dialog
     * @param context  上下文
     * @param msg  显示内容
     * @param isTransBg 是否透明
     * @param isCancelable 是否可以点击取消
     * @return
     */
    public static Dialog showWaitDialog(Context context, String msg, boolean isTransBg, boolean isCancelable) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.career_loding_layout, null);             // 得到加载view
        RelativeLayout layout = (RelativeLayout) v.findViewById(R.id.dialog_view);// 加载布局

        // main.xml中的ImageView
        spaceshipImage = (NewGifView) v.findViewById(R.id.img);
        TextView tipTextView = (TextView) v.findViewById(R.id.tipTextView);   // 提示文字
        // 加载动画
//        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(context, R.anim.career_rotate_animation);
        // 使用ImageView显示动画
//        spaceshipImage.startAnimation(hyperspaceJumpAnimation);

        spaceshipImage.setMovieResource(R.raw.lodingimage);
        tipTextView.setText(msg);// 设置加载信息

        isTransBg = true;
        Dialog loadingDialog = new Dialog(context, isTransBg ? R.style.TransDialogStyle : R.style.WhiteDialogStyle);    // 创建自定义样式dialog
        loadingDialog.setContentView(layout);
        loadingDialog.setCancelable(isCancelable);
        loadingDialog.setCanceledOnTouchOutside(false);

        Window window = loadingDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setGravity(Gravity.CENTER);
        window.setAttributes(lp);
        window.setWindowAnimations(R.style.PopWindowAnimStyle);

        //判断上下文是否是 activity，如果是需要判断 activity 是否关闭
        if (context instanceof Activity){
            Activity activity = (Activity) context;
            if (!activity.isFinishing()){
                loadingDialog.show();
            }
        }
        return loadingDialog;
    }

    /**
     * 关闭dialog
     * @param mDialogUtils
     */
    public static void closeDialog(Dialog mDialogUtils) {
        if (mDialogUtils != null && mDialogUtils.isShowing()) {

            spaceshipImage.setMovieResource(R.raw.lodingimage);
            mDialogUtils.dismiss();
        }
    }
}