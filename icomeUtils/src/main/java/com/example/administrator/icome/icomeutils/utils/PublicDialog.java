package com.example.administrator.icome.icomeutils.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.administrator.icome.icomeutils.R;


/**
 * @author caozhuangzhuang
 * @create 2018/10/19
 * @Describe 删除提示框
 */

public class PublicDialog extends Dialog implements View.OnClickListener {

    TextView tvMessage;
    View viewLine;
    TextView tvCancel;
    TextView tvConfirm;
    private Context context;
    private String message, cancel, confirm;
    private IClickListener iClickListener;



    public PublicDialog(Context context, String message, String cancel, String confirm) {
        super(context, R.style.super_dialog);
        this.context = context;
        this.message = message;
        this.cancel = cancel;
        this.confirm = confirm;
    }

    public void setiClickListener(IClickListener iClickListener) {
        this.iClickListener = iClickListener;
    }

    public TextView getTvMessage() {
        return tvMessage;
    }

    public void setTvMessage(TextView tvMessage) {
        this.tvMessage = tvMessage;
    }

    public TextView getTvConfirm() {
        return tvConfirm;
    }

    public void setTvConfirm(TextView tvConfirm) {
        this.tvConfirm = tvConfirm;
    }

    public TextView getTvCancel() {
        return tvCancel;
    }

    public void setTvCancel(TextView tvCancel) {
        this.tvCancel = tvCancel;
    }

    private void setingDialog() {
        WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
        localLayoutParams.gravity = Gravity.CENTER;
        localLayoutParams.x = LayoutParams.MATCH_PARENT;
        localLayoutParams.y = LayoutParams.WRAP_CONTENT;
        localLayoutParams.width = LayoutParams.MATCH_PARENT;
        localLayoutParams.height = LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(localLayoutParams);
//        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_public_view);
        setingDialog();
        init();
        addListener();
    }

    public void init() {
        tvMessage = findViewById(R.id.tv_message);
        viewLine = findViewById(R.id.view_line);
        tvCancel = findViewById(R.id.tv_cancel);
        tvConfirm = findViewById(R.id.tv_confirm);
        if (!TextUtils.isEmpty(message)) {
            tvMessage.setText(message);
        }
        if (!TextUtils.isEmpty(cancel)) {
            tvCancel.setText(cancel);
        } else {
            tvCancel.setVisibility(View.GONE);
            viewLine.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(confirm)) {
            tvConfirm.setText(confirm);
        }else{
            tvConfirm.setVisibility(View.GONE);
            tvConfirm.setVisibility(View.GONE);
        }
    }

    public void addListener() {
        tvConfirm.setOnClickListener(this);
        tvCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        dismiss();
        if (v.getId() == R.id.tv_confirm) {
            if (null != iClickListener && iClickListener instanceof IClickListener) {
                iClickListener.confirmClick();
            }
        } else if (v.getId() == R.id.tv_cancel) {
            if (null != iClickListener && iClickListener instanceof IClickListener) {
                iClickListener.cancelClick();
            }
        }
    }

    public interface IClickListener {
        void confirmClick();

        void cancelClick();
    }
}
