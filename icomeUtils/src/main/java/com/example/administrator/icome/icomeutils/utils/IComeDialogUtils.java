package com.example.administrator.icome.icomeutils.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.icome.icomeutils.R;

public class IComeDialogUtils {
    private static volatile IComeDialogUtils instance = null;
    private TextView mEnter2;
    private TextView mEsc2;
    private String mMBidderName;
    private TextView mMtextview;
    private String mName;
    private Handler handler;
    private View view;
    private Animation animation;
    private int mSelectPostion;

    public static IComeDialogUtils getInstance() {
        if (null == instance) {
            synchronized (IComeDialogUtils.class) {
                if (null == instance) {
                    instance = new IComeDialogUtils();
                }
            }
        }
        return instance;
    }

    public interface Dialog2Listener {
        void leftOnclick();

        void rightOnclick();

        void rightOnclick(String edit);

        void dismiss();
    }

    public Dialog getDialog(Context context, View view, String title) {
        Dialog dialog = new Dialog(context, R.style.LoadDialog);
        dialog.setContentView(view);
        Bundle bundle = new Bundle();
        mName = bundle.getString("name");
        return dialog;
    }

    /**
     * 更改团队负责人提示
     */
    public void finishDialog(Context context, final Dialog2Listener linstener) {
        View view = LayoutInflater.from(context).inflate(R.layout.finish, null);
        mEsc2 = view.findViewById(R.id.finish_cancel);
        mEnter2 = view.findViewById(R.id.finish_confirm);
        final Dialog mDialogs = getDialog(context, view, null);
        mEsc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (linstener != null) {
                    linstener.leftOnclick();
                }
                mDialogs.dismiss();

            }
        });
        mEnter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (linstener != null) {
                    linstener.rightOnclick();
                }
                mDialogs.dismiss();
            }
        });
        // 对话框dismiss监听方法
        mDialogs.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                if (linstener != null) {
                    linstener.dismiss();
                }
            }
        });
        mDialogs.show();
    }

    /**
     * 删除团队时，动态提示
     */
    public void deleteTeam(Context context, final Dialog2Listener linstener) {
        View view = LayoutInflater.from(context).inflate(R.layout.delete_team, null);
        mEsc2 = view.findViewById(R.id.finish_cancel);
        mEnter2 = view.findViewById(R.id.finish_confirm);
        final Dialog mDialogs = getDialog(context, view, null);
        mEsc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (linstener != null) {
                    linstener.leftOnclick();
                }
                mDialogs.dismiss();

            }
        });
        mEnter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (linstener != null) {
                    linstener.rightOnclick();
                }
                mDialogs.dismiss();
            }
        });
        // 对话框dismiss监听方法
        mDialogs.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                if (linstener != null) {
                    linstener.dismiss();
                }
            }
        });
        mDialogs.show();
    }

    /**
     * 任务已完成改为未完成提示
     */
    public void taskUndone(Context context, final Dialog2Listener linstener) {
        View view = LayoutInflater.from(context).inflate(R.layout.task_undone_team, null);
        mEsc2 = view.findViewById(R.id.finish_cancel);
        mEnter2 = view.findViewById(R.id.finish_confirm);
        final Dialog mDialogs = getDialog(context, view, null);
        mEsc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (linstener != null) {
                    linstener.leftOnclick();
                }
                mDialogs.dismiss();

            }
        });
        mEnter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (linstener != null) {
                    linstener.rightOnclick();
                }
                mDialogs.dismiss();
            }
        });
        // 对话框dismiss监听方法
        mDialogs.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                if (linstener != null) {
                    linstener.dismiss();
                }
            }
        });
        mDialogs.show();
    }

    /**
     * 取消任务提示
     */
    public void cancelTask(Context context, final Dialog2Listener linstener) {
        View view = LayoutInflater.from(context).inflate(R.layout.cancel_task_team, null);
        mEsc2 = view.findViewById(R.id.finish_cancel);
        mEnter2 = view.findViewById(R.id.finish_confirm);
        final Dialog mDialogs = getDialog(context, view, null);
        mEsc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (linstener != null) {
                    linstener.leftOnclick();
                }
                mDialogs.dismiss();

            }
        });
        mEnter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (linstener != null) {
                    linstener.rightOnclick();
                }
                mDialogs.dismiss();
            }
        });
        // 对话框dismiss监听方法
        mDialogs.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                if (linstener != null) {
                    linstener.dismiss();
                }
            }
        });
        mDialogs.show();
    }

    /**
     * 删除任务提示
     */
    public void deleteTask(Context context, final Dialog2Listener linstener) {
        View view = LayoutInflater.from(context).inflate(R.layout.delete_task_team, null);
        mEsc2 = view.findViewById(R.id.finish_cancel);
        mEnter2 = view.findViewById(R.id.finish_confirm);
        final Dialog mDialogs = getDialog(context, view, null);
        mEsc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (linstener != null) {
                    linstener.leftOnclick();
                }
                mDialogs.dismiss();

            }
        });
        mEnter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (linstener != null) {
                    linstener.rightOnclick();
                }
                mDialogs.dismiss();
            }
        });
        // 对话框dismiss监听方法
        mDialogs.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                if (linstener != null) {
                    linstener.dismiss();
                }
            }
        });
        mDialogs.show();
    }

    /**
     * 我的问答已解决提示
     */
    public void solved(Context context, final Dialog2Listener linstener) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_solved_team, null);
        mEsc2 = view.findViewById(R.id.finish_cancel);
        mEnter2 = view.findViewById(R.id.finish_confirm);
        final Dialog mDialogs = getDialog(context, view, null);
        mEsc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (linstener != null) {
                    linstener.leftOnclick();
                }
                mDialogs.dismiss();

            }
        });
        mEnter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (linstener != null) {
                    linstener.rightOnclick();
                }
                mDialogs.dismiss();
            }
        });
        // 对话框dismiss监听方法
        mDialogs.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                if (linstener != null) {
                    linstener.dismiss();
                }
            }
        });
        mDialogs.show();
    }

    /**
     * 输入任务进度
     */
    public void editProgress(final Context context, String title, final Dialog2Listener listener) {

        View mView = LayoutInflater.from(context).inflate(R.layout.edit_progress_item, null);
        final EditText mDialogEdit = mView.findViewById(R.id.edit_content);
        TextView mEsc = mView.findViewById(R.id.dialog_esc);
        TextView mEnter = mView.findViewById(R.id.dialog_enter);

        final Dialog mDialog = getDialog(context, mView, title);
        mEsc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.leftOnclick();
                }
                mDialog.dismiss();
                hideSoftInput(context, mDialogEdit);
            }
        });
        mEnter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (listener != null) {
                    listener.rightOnclick(mDialogEdit.getText().toString().trim());
                }
                mDialog.dismiss();
                hideSoftInput(context, mDialogEdit);
            }
        });
        mDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.showSoftInput(mDialogEdit, InputMethodManager.SHOW_IMPLICIT);
                }
            }
        });
        // 对话框dismiss监听方法
        mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface arg0) {
                if (listener != null) {
                    listener.dismiss();
                }
            }
        });
        mDialog.show();


    }

    /**
     * 输入关键节点
     */
    public void editKeyNode(final Context context, String title, final Dialog2Listener listener) {
        View mView = LayoutInflater.from(context).inflate(R.layout.edit_key_node_item, null);
        final EditText mDialogEdit = mView.findViewById(R.id.edit_content);
        TextView mEsc = mView.findViewById(R.id.dialog_esc);
        TextView mEnter = mView.findViewById(R.id.dialog_enter);

        final Dialog mDialog = getDialog(context, mView, title);
        mEsc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.leftOnclick();
                }
                mDialog.dismiss();
                hideSoftInput(context, mDialogEdit);
            }
        });
        mEnter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (listener != null) {
                    listener.rightOnclick(mDialogEdit.getText().toString().trim());
                }
                mDialog.dismiss();
                hideSoftInput(context, mDialogEdit);
            }
        });
        mDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.showSoftInput(mDialogEdit, InputMethodManager.SHOW_IMPLICIT);
                }
            }
        });
        // 对话框dismiss监听方法
        mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface arg0) {
                if (listener != null) {
                    listener.dismiss();
                }
            }
        });
        mDialog.show();


    }

    /**
     * 隐藏软键盘
     */
    private void hideSoftInput(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
