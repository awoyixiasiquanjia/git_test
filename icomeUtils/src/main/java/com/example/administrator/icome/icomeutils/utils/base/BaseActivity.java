package com.example.administrator.icome.icomeutils.utils.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

import com.example.administrator.icome.icomeutils.R;
import com.example.administrator.icome.icomeutils.utils.BaseAppManager;
import com.example.administrator.icome.icomeutils.utils.LoadingDailog;
import com.example.administrator.icome.icomeutils.utils.SharedPreferencesUtils;
import com.example.administrator.icome.icomeutils.utils.utils.Router;
import com.umeng.analytics.MobclickAgent;

import org.json.JSONException;

import butterknife.ButterKnife;

import com.example.administrator.icome.icomeutils.utils.mvp.BasePresenter;

import static com.example.administrator.icome.icomeutils.utils.constants.ValueChainCommentConstant.VALUE_CHAIN_PUBLISH_COMMENT;
import static com.example.administrator.icome.icomeutils.utils.constants.ValueChainCommentConstant.showCommentBar;

/**
 * 基础activity类
 * Created by JamesJiang on 2017/4/25.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements IIntentActivityUtil {
    private static boolean tag = false;
    protected T presenter;
    protected LoadingDailog loadingDailog;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // 设置设备为竖屏模式
        presenter = createPresenter();
        //沉浸式
        setTranslucentStatus();
        Bundle extras = getIntent().getExtras();
        if (null != extras) {
            getBundleExtras(extras);
        }
        if (getContentViewLayoutID() != 0) {
            if (showCommentBar) {
                showCommentBar = false;
                showContentView();
            } else {
                setContentView(getContentViewLayoutID());
            }
        } else {
            throw new IllegalArgumentException("You must return a right contentView layout resource Id");
        }
        ButterKnife.bind(this);
        BaseAppManager.getInstance().addActivity(this);
        try {
            initViewsAndEvents();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        getResources();
    }

    protected T createPresenter() {
        return null;
    }

    ;

    protected abstract void getBundleExtras(Bundle extras);

    protected abstract int getContentViewLayoutID();

    protected abstract void initViewsAndEvents() throws JSONException;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //注册广播
        registerReceiver(mHomeKeyEventReceiver, new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS));
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mHomeKeyEventReceiver != null) {
            this.unregisterReceiver(mHomeKeyEventReceiver);
        }
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BaseAppManager.getInstance().removeActivity(this);
        if (presenter != null) {
            presenter.detachView();
        }
    }

    /**
     * startActivity
     *
     * @param clazz
     */
    @Override
    public void readyGo(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    /**
     * startActivity with bundle
     *
     * @param clazz
     * @param bundle
     */
    @Override
    public void readyGo(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);

        }
        startActivity(intent);
    }

    /**
     * startActivity then finish
     *
     * @param clazz
     */
    @Override
    public void readyGoThenKill(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        finish();
    }

    /**
     * startActivity with bundle then finish
     *
     * @param clazz
     * @param bundle
     */
    @Override
    public void readyGoThenKill(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        finish();
    }

    /**
     * startActivityForResult
     *
     * @param clazz
     * @param requestCode
     */
    @Override
    public void readyGoForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(this, clazz);
        startActivityForResult(intent, requestCode);
    }

    /**
     * startActivityForResult with bundle
     *
     * @param clazz
     * @param requestCode
     * @param bundle
     */
    @Override
    public void readyGoForResult(Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /*** 监听是否点击了home键将客户端推到后台*/
    private BroadcastReceiver mHomeKeyEventReceiver = new BroadcastReceiver() {
        String SYSTEM_REASON = "reason";
        String SYSTEM_HOME_KEY = "homekey";
        String SYSTEM_HOME_KEY_LONG = "recentapps";

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)) {
                String reason = intent.getStringExtra(SYSTEM_REASON);
                if (TextUtils.equals(reason, SYSTEM_HOME_KEY)) {
                    onHomeKey();
                } else if (TextUtils.equals(reason, SYSTEM_HOME_KEY_LONG)) {
                    onMenuKey();
                }
            }
        }
    };

    protected void onHomeKey() {}

    protected void onMenuKey() {}

    /**
     * 设置状态栏透明
     */
    protected void setTranslucentStatus() {
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏颜色
            window.setStatusBarColor(Color.TRANSPARENT);
            //设置导航栏颜色
            window.setNavigationBarColor(Color.BLACK);
            ViewGroup contentView = ((ViewGroup) findViewById(android.R.id.content));
            View childAt = contentView.getChildAt(0);
            if (childAt != null) {
                childAt.setFitsSystemWindows(true);
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

    }

    /**
     * 检查网络是否可用
     *
     * @param context
     * @return
     */
    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context
                .getApplicationContext().getSystemService(
                        Context.CONNECTIVITY_SERVICE);
        if (manager == null) {
            return false;
        }
        NetworkInfo networkinfo = manager.getActiveNetworkInfo();
        if (networkinfo == null || !networkinfo.isAvailable()) {
            return false;
        }
        return true;
    }


    public void hidSoftKeybord(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }
    public void hidSoftKeybord() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public void showSoftKeybord() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * 视图占据状态栏
     */
    public void hideActionBar() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    /**
     * 显示加载框
     */
    protected void initDialog() {
        if (loadingDailog == null) {
            loadingDailog = new LoadingDailog.Builder(this)
                    .setMessage("加载中")
                    .setCancelable(true)
                    .setCancelOutside(false).create();
        }
        loadingDailog.show();
    }

    protected void closeDialog() {
        if (loadingDailog != null) {
            loadingDailog.dismiss();
        }
    }

    /**
     * 重置App界面的字体大小，fontScale 值为 1 代表默认字体大小
     *
     * @return suyan
     */
    @Override
    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = new Configuration();
        configuration.setToDefaults();
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return resources;
    }

    /**
     * 添加公用的底部栏
     */
    public void showContentView() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.base_bottom_bar_layout, null);
        LinearLayout linearLayout = contentView.findViewById(R.id.contentLayout);
        contentView.findViewById(R.id.ivCommentBar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addComment();
            }
        });

        View mainView = LayoutInflater.from(this).inflate(getContentViewLayoutID(), null);
        mainView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayout.addView(mainView);
        setContentView(contentView);
    }


    /**
     * 跳转至添加评论
     * 传递相应参数
     */
    protected void addComment() {
        Router.getInstance().startActivity(this,VALUE_CHAIN_PUBLISH_COMMENT);
    }
}
