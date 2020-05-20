package com.example.administrator.icome.icomeutils.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.example.administrator.icome.icomeutils.R;
import java.util.ArrayList;

/**
 * Author ：Tom
 * Date ：2015/9/27 00:56
 * dialog 浮层设计
 */
public class MyNewDialog {
    private static String TAG = "MyNewDialog";
    private TextView mEnter2;
    private TextView mEsc2;
    private String mMBidderName;
    private TextView mMtextview;
    private String mName;
    private Handler handler;
    private View view;
    private Animation animation;

    public interface newDialogListener {
        void guideOnclick(ImageView imageView, Dialog mdialog);
    }

    public interface Dialog2Listener {
        void leftOnclick();

        void rightOnclick();

        void rightOnclick(String edit);

        void guideOnclick(ImageView imageView, Dialog mdialog);

        void dismiss();
    }

    public interface DialogListener {
        void rightOnclick();

        void dismiss();
    }

    public Dialog getDialog(Context context, View view, String title) {
        Dialog dialog = new Dialog(context, R.style.MyNewLoadDialog);
        dialog.setContentView(view);
        Bundle bundle = new Bundle();
        mName = bundle.getString("name");
        return dialog;
    }

    /**
     * 引导浮层
     *
     * @param context
     */
    public void guideDialog(final Activity context, final Dialog2Listener listener, int imageId, boolean isJump) {
        View mView = LayoutInflater.from(context).inflate(R.layout.newdialog_layout, null);
        LinearLayout layout = mView.findViewById(R.id.newdialog_layout);
        layout.setVisibility(View.GONE);
        final ImageView tishi = mView.findViewById(R.id.newreviewts_image);
        tishi.setVisibility(View.VISIBLE);
        tishi.setImageResource(imageId);

        //设置Dialog浮层全屏显示
        final Dialog mDialog = getDialog(context, mView, null);
        Window window = mDialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = ViewGroup.LayoutParams.MATCH_PARENT;
        attributes.height = ViewGroup.LayoutParams.MATCH_PARENT;
        mDialog.onWindowAttributesChanged(attributes);
        mDialog.show();

        tishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.guideOnclick(tishi, mDialog);
                }
            }
        });

        //浮层显示跳过开关
        if (isJump){
            TextView jumpOver = mView.findViewById(R.id.jumpOver);
            jumpOver.setVisibility(View.GONE);
            //跳过的点击事件
            jumpOver.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDialog.dismiss();
                }
            });
        }
    }


    /**
     * 工作台 引导浮层
     * @param context
     * @param newListener
     * @param imageId
     * @param isJump
     */
    public void workBenchGuideDialog(final Activity context, final newDialogListener newListener, final int imageId, boolean isJump) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_floatview, null);
        final ImageView dialogImage = view.findViewById(R.id.dialog_image);
        dialogImage.setVisibility(View.VISIBLE);
        dialogImage.setImageResource(imageId);

        //设置Dialog浮层全屏显示
        final Dialog mDialog = getDialog(context, view, null);
        Window window = mDialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = ViewGroup.LayoutParams.MATCH_PARENT;
        attributes.height = ViewGroup.LayoutParams.MATCH_PARENT;
        mDialog.onWindowAttributesChanged(attributes);
        mDialog.show();

        //保持页面 dialog 不消失
        dialogImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置点击屏幕不消失
                mDialog.setCanceledOnTouchOutside(false);
                //设置点击返回键不消失
//                mDialog.setCancelable(false);
                mDialog.show();
            }
        });

        //动态添加view对应点击区域
        final TextView firstImage = view.findViewById(R.id.firstFloatImage);
        final TextView secondImage = view.findViewById(R.id.secondFloatImage);
        final TextView thirdImage = view.findViewById(R.id.thirdFloatImage);
        final TextView fourthImage = view.findViewById(R.id.fourthFloatImage);

        //默认显示第一图，之后依次显示隐藏 跳至下一页
        firstImage.setVisibility(View.VISIBLE);
        firstImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newListener != null) {
                    newListener.guideOnclick(dialogImage, mDialog);
                    firstImage.setVisibility(View.GONE);
                    secondImage.setVisibility(View.VISIBLE);
                }
            }
        });

        secondImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newListener != null) {
                    newListener.guideOnclick(dialogImage, mDialog);
                    secondImage.setVisibility(View.GONE);
                    thirdImage.setVisibility(View.VISIBLE);
                }
            }
        });

        thirdImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newListener != null) {
                    newListener.guideOnclick(dialogImage, mDialog);
                    thirdImage.setVisibility(View.GONE);
                    fourthImage.setVisibility(View.VISIBLE);
                }
            }
        });

        fourthImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newListener != null) {
                    newListener.guideOnclick(dialogImage, mDialog);
                    fourthImage.setVisibility(View.GONE);
                }
            }
        });

        //浮层显示跳过开关
        if (isJump){
            TextView jumpBtn = view.findViewById(R.id.jumpBtn);
            jumpBtn.setVisibility(View.VISIBLE);
            //跳过的点击事件
            jumpBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDialog.dismiss();
                }
            });
        }
    }

    /**
     * 显示选择的弹框
     *
     * @param mContext
     * @param list
     * @param dialotListene
     */
    public void showListDialog(Context mContext, final ArrayList<String> list, final DialotListViewListene dialotListene) {
        final Dialog dialog = new Dialog(mContext, R.style.MyLoadingDialogStyle);
        View mView = LayoutInflater.from(mContext).inflate(R.layout.dialog_botmon_select, null);
        TextView tvCancel = mView.findViewById(R.id.dialog_web_escs);
        ListView listView = mView.findViewById(R.id.list_view);
        listView.setAdapter(new DialotBotmonAdapter(mContext, list));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialotListene.listViewListen(position, list.get(position));
                dialog.dismiss();
            }
        });
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setContentView(mView);
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.show();

    }

    /**
     * 显示选择的弹框
     *
     * @param mContext
     * @param list
     * @param dialotListene
     */
    public void showListDialog(Context mContext, final ArrayList<String> list, String title, final DialotListViewListene dialotListene) {
        final Dialog dialog = new Dialog(mContext, R.style.MyLoadingDialogStyle);
        View mView = LayoutInflater.from(mContext).inflate(R.layout.dialog_botmon_select, null);
        TextView tvCancel = mView.findViewById(R.id.dialog_web_escs);
        ListView listView = mView.findViewById(R.id.list_view);
        if (!TextUtils.isEmpty(title)) {
            LinearLayout dialog_title_ll = mView.findViewById(R.id.dialog_title_ll);
            dialog_title_ll.setVisibility(View.VISIBLE);
            TextView dialog_title = mView.findViewById(R.id.dialog_title);
            dialog_title.setText(title);
        }
        listView.setAdapter(new DialotBotmonAdapter(mContext, list));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialotListene.listViewListen(position, list.get(position));
                dialog.dismiss();
            }
        });
        tvCancel.setTextColor(Color.parseColor("#3781FE"));
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setContentView(mView);
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.show();

    }

    public interface DialotListViewListene {
        void listViewListen(int position, String content);
    }

    public void showEditDialog(Context mContext, String strContext, final DialogEditListen dialogEditListen) {
        final Dialog dialog = new Dialog(mContext, R.style.MyLoadingDialogStyle);
        View mView = LayoutInflater.from(mContext).inflate(R.layout.edit_updata_dialog, null);
        TextView tvDscs = mView.findViewById(R.id.newdialog_web_escs);
        TextView tvCancel = mView.findViewById(R.id.newdialog_web_enter);
        final EditText edUpdata = mView.findViewById(R.id.ed_updata_dialog);
//        edUpdata.setFilters(new InputFilter[]{EditTextInputUtils.typeFilter, new InputFilter.LengthFilter(30)});
        edUpdata.setText(strContext);
        edUpdata.setSelection(strContext.length());//光标在最后
        tvDscs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String trim = edUpdata.getText().toString().trim();
                if (TextUtils.isEmpty(trim)) {
                    dialog.dismiss();
                    //任务名称为空，关闭对话框
                    return;
                }
                dialogEditListen.editListen(trim, dialog);
            }
        });
        dialog.setContentView(mView);
        dialog.show();
    }

    public ImageView showCenterDialog(Context mContext, String title, boolean showIcon, String content, final DialogEditListen dialogEditListen) {
        final Dialog dialog = new Dialog(mContext, R.style.MyLoadingDialogStyle);
        View mView = LayoutInflater.from(mContext).inflate(R.layout.center_confirm_dialog, null);
        TextView tvDscs = mView.findViewById(R.id.newdialog_web_escs);
        TextView tvCancel = mView.findViewById(R.id.newdialog_web_enter);
        final TextView center_c_title = mView.findViewById(R.id.center_c_title);
        final ImageView center_content_icon = mView.findViewById(R.id.center_content_icon);
        final TextView center_content_title = mView.findViewById(R.id.center_content_title);
        if (TextUtils.isEmpty(title)) {
            center_c_title.setVisibility(View.GONE);
        } else {
            center_c_title.setText(title);
        }
        if (!showIcon) {
            center_content_icon.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(content)) {
            center_content_title.setText(content);
        } else {
            center_content_title.setVisibility(View.GONE);
        }

        tvDscs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogEditListen.editListen("", dialog);
                dialog.dismiss();
            }
        });
        dialog.setContentView(mView);
        dialog.show();
        return center_content_icon;
    }

    public interface DialogEditListen {
        void editListen(String context, Dialog dialog);
    }

    /**
     * 下载文件提示框
     *
     * @param context
     * @param linstener
     */
    public void openFile(Context context, final Dialog2Listener linstener) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_getfile, null);
        TextView mTv = view.findViewById(R.id.dialog_tv1);
        mTv.setText("请下载后查看");
        mEnter2 = view.findViewById(R.id.dialog_enter1);
        mEsc2 = view.findViewById(R.id.dialog_esc2);
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
     * 推送提示框
     *
     * @param context
     * @param linstener
     */
    public void isNotificationEnabled(Context context, final Dialog2Listener linstener) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_getfile, null);
        TextView mTv = view.findViewById(R.id.dialog_tv1);
        mTv.setText("您没有开启icome的新消息通知,快\n去开启推送设置吧~");
        mEnter2 = view.findViewById(R.id.dialog_enter1);
        mEnter2.setText("立即开启");
        mEsc2 = view.findViewById(R.id.dialog_esc2);
        mEsc2.setText("稍后设置");

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

        mDialogs.setCanceledOnTouchOutside(false);
        mDialogs.show();

    }

    /**
     * 将决策人加入到群
     */
    public void addEndUser(Context context, final Dialog2Listener linstener) {
        View view = LayoutInflater.from(context).inflate(R.layout.add_end_user_layout, null);
        mEsc2 = view.findViewById(R.id.pass_cancel);
        mEnter2 = view.findViewById(R.id.pass_confirm);
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
     * 第一次添加星标提示
     *
     * @param text
     * @param context
     * @param linstener
     */
    public void showCollectionDialog(String text, Context context, final DialogListener linstener) {
        View view = LayoutInflater.from(context).inflate(R.layout.workbench_collection_layout, null);
        mEsc2 = view.findViewById(R.id.tv_zhidao);
        TextView textView = view.findViewById(R.id.dialog_tv1);
        textView.setText(text);
        final Dialog mDialogs = getDialog(context, view, null);
        mEsc2.setOnClickListener(new View.OnClickListener() {
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

}
