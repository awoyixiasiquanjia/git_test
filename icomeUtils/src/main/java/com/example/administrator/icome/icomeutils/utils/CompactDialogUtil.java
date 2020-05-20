package com.example.administrator.icome.icomeutils.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.administrator.icome.icomeutils.R;


/**
 * AlertDialog 管理类
 *
 * @author by Lilong on 18/1/10
 */
public class CompactDialogUtil {

    /**
     * 弹出Dialog，
     *
     * @param context        -- 上下文
     * @param title          -- 标题
     * @param msg            -- 内容
     * @param okListener     -- 确定按钮事件
     * @param cancelListener --
     * @param isTouchCancel
     */
    public static void showDialog(Context context, String title, String msg, String confirmLab,
                                  DialogInterface.OnClickListener okListener, String cancelLab,
                                  DialogInterface.OnClickListener cancelListener, boolean isTouchCancel) {

        AlertDialog.Builder builder = dialogBuilder(context, title, msg, confirmLab, okListener, cancelLab,
                cancelListener);

        AlertDialog alertDialog = builder.create();
        if (isTouchCancel) {
            alertDialog.setCancelable(false);
            alertDialog.setCanceledOnTouchOutside(false);
        }
        alertDialog.show();
    }

    /**
     * 创建一个alertDialog
     */
    public static AlertDialog.Builder dialogBuilder(Context context, String title, String msg, String confirmLab,
                                                    DialogInterface.OnClickListener okListener, String cancelLab, DialogInterface.OnClickListener cancelListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (!TextUtils.isEmpty(title)) {
            builder.setTitle(title);
        }
        if (!TextUtils.isEmpty(msg)) {
            builder.setMessage(msg);
        }
        if (!TextUtils.isEmpty(confirmLab)) {
            builder.setPositiveButton(confirmLab, okListener != null ? okListener : null);
        }
        if (!TextUtils.isEmpty(cancelLab)) {
            builder.setNegativeButton(cancelLab, cancelListener != null ? cancelListener : null);
        }
        return builder;
    }

    public static void showTips(@NonNull Context context, CharSequence content, final View.OnClickListener onClickListener) {
        final Dialog dialog = new Dialog(context, R.style.MyLoadDialog);
        View mView = LayoutInflater.from(context).inflate(R.layout.dialog_tips, null);
        TextView mEnter = mView.findViewById(R.id.dialog_web_enter);
        TextView mTitle = mView.findViewById(R.id.edit_content);
        mTitle.setText(content);
        dialog.setContentView(mView);
        dialog.show();
        mEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (null != onClickListener) {
                    onClickListener.onClick(v);
                }
            }
        });
    }

    public static void showDialog(@NonNull Context context, CharSequence content, OnMultiChoiceClickListener onMultiChoiceClickListener) {
        showDialog(context, content, null, null, false, onMultiChoiceClickListener);
    }

    @Deprecated
    public static void showDialog(@NonNull Context context, CharSequence content, CharSequence enter, CharSequence esc, boolean cancelable, final OnMultiChoiceClickListener onMultiChoiceClickListener) {
        final Dialog dialog = new Dialog(context, R.style.MyLoadDialog);
        View mView = LayoutInflater.from(context).inflate(R.layout.delete_2_dialog, null);
        TextView mContent = mView.findViewById(R.id.content);
        TextView mEnter = mView.findViewById(R.id.dialog_delete_enter);
        TextView mEsc = mView.findViewById(R.id.dialog_delete_esc);
        mContent.setText(content);
        dialog.setContentView(mView);
        dialog.setCancelable(cancelable);
        mEnter.setText("确定");
        if (!TextUtils.isEmpty(enter)) {
            mEnter.setText(enter);
        }
        mEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (null != onMultiChoiceClickListener) {
                    onMultiChoiceClickListener.onClick(v, OnMultiChoiceClickListener.BUTTON_POSITIVE);
                }
            }
        });
        if (!TextUtils.isEmpty(esc)) {
            mEsc.setText(esc);
        }
        mEsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (null != onMultiChoiceClickListener) {
                    onMultiChoiceClickListener.onClick(v, OnMultiChoiceClickListener.BUTTON_NEGATIVE);
                }
            }
        });
        dialog.show();
    }

    public static void showDialog(@NonNull Context context, CharSequence content, Rect rect, OnMultiChoiceClickListener onMultiChoiceClickListener) {
        showDialog(context, content, null, null, false, rect, onMultiChoiceClickListener);
    }

    public static void showDialog(@NonNull Context context, CharSequence content, CharSequence enter, CharSequence esc, boolean cancelable, Rect rect, final OnMultiChoiceClickListener onMultiChoiceClickListener) {
        final Dialog dialog = new Dialog(context, R.style.MyLoadDialog);
        View mView = LayoutInflater.from(context).inflate(R.layout.compact_delete_2_dialog, null);
        TextView mContent = mView.findViewById(R.id.content);
        TextView mEnter = mView.findViewById(R.id.dialog_delete_enter);
        TextView mEsc = mView.findViewById(R.id.dialog_delete_esc);
        mContent.setText(content);
        dialog.setContentView(mView);
        dialog.setCancelable(cancelable);
        if (!TextUtils.isEmpty(enter)) {
            mEnter.setText(enter);
        }
        mEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (null != onMultiChoiceClickListener) {
                    onMultiChoiceClickListener.onClick(v, OnMultiChoiceClickListener.BUTTON_POSITIVE);
                }
            }
        });
        if (!TextUtils.isEmpty(esc)) {
            mEsc.setText(esc);
        }
        mEsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (null != onMultiChoiceClickListener) {
                    onMultiChoiceClickListener.onClick(v, OnMultiChoiceClickListener.BUTTON_NEGATIVE);
                }
            }
        });
        dialog.show();
        if (null != rect) {
            WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
            if (rect.width() > 0) {
                params.width = rect.width();
            }
            if (rect.height() > 0) {
                params.height = rect.height();
            }
            dialog.getWindow().setAttributes(params);
        }
    }

    public static void showDialog(@NonNull Context context, CharSequence title, CharSequence content, OnMultiChoiceClickListener onMultiChoiceClickListener) {
        showDialog(context, title, content, null, null, false, null, onMultiChoiceClickListener);
    }

    public static void showDialog(@NonNull Context context, CharSequence title, CharSequence content, Rect rect, OnMultiChoiceClickListener onMultiChoiceClickListener) {
        showDialog(context, title, content, null, null, false, rect, onMultiChoiceClickListener);
    }

    public static void showDialog(@NonNull Context context, CharSequence title, CharSequence content, CharSequence enter, CharSequence esc, OnMultiChoiceClickListener onMultiChoiceClickListener) {
        showDialog(context, title, content, enter, esc, false, null, onMultiChoiceClickListener);
    }

    public static void showDialog(@NonNull Context context, CharSequence title, CharSequence content, CharSequence enter, CharSequence esc, Rect rect, OnMultiChoiceClickListener onMultiChoiceClickListener) {
        showDialog(context, title, content, enter, esc, false, rect, onMultiChoiceClickListener);
    }

    public static void showDialog(@NonNull Context context, CharSequence title, CharSequence content, CharSequence enter, CharSequence esc, boolean cancelable, Rect rect, final OnMultiChoiceClickListener onMultiChoiceClickListener) {
        final Dialog dialog = new Dialog(context, R.style.MyLoadDialog);
        View mView = LayoutInflater.from(context).inflate(R.layout.compact_delete_3_dialog, null);
        TextView mTitle = mView.findViewById(R.id.title);
        TextView mContent = mView.findViewById(R.id.content);
        TextView mEnter = mView.findViewById(R.id.dialog_delete_enter);
        TextView mEsc = mView.findViewById(R.id.dialog_delete_esc);
        if (TextUtils.isEmpty(title)) {
            mTitle.setVisibility(View.GONE);
        } else {
            mTitle.setVisibility(View.VISIBLE);
            mTitle.setText(title);
        }
        mContent.setText(content);
        if (!TextUtils.isEmpty(enter)) {
            mEnter.setText(enter);
        }
        mEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (null != onMultiChoiceClickListener) {
                    onMultiChoiceClickListener.onClick(v, OnMultiChoiceClickListener.BUTTON_POSITIVE);
                }
            }
        });
        if (!TextUtils.isEmpty(esc)) {
            mEsc.setText(esc);
        }
        mEsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (null != onMultiChoiceClickListener) {
                    onMultiChoiceClickListener.onClick(v, OnMultiChoiceClickListener.BUTTON_NEGATIVE);
                }
            }
        });
        dialog.setContentView(mView);
        dialog.setCancelable(cancelable);
        dialog.show();
        if (null != rect) {
            WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
            if (rect.width() > 0) {
                params.width = rect.width();
            }
            if (rect.height() > 0) {
                params.height = rect.height();
            }
            dialog.getWindow().setAttributes(params);
        }
    }
}
