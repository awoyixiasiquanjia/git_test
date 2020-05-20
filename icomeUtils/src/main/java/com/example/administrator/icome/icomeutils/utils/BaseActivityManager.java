package com.example.administrator.icome.icomeutils.utils;

import android.app.Activity;
import java.util.LinkedList;
import java.util.List;

/**
 * created by hongwang on 2020/3/17
 * 重新定义的获取Activity实例对象
 */
public class BaseActivityManager {
    private List<Activity> activityList = new LinkedList<Activity>();
    private static BaseActivityManager instance;

    private BaseActivityManager() {
    }

    // 单例模式中获取唯一的AppManager实例
    public static BaseActivityManager getInstance() {
        if (null == instance) {
            instance = new BaseActivityManager();
        }
        return instance;
    }

    // 添加Activity到容器中
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    // 删除
    public void removeActivity(Activity activity) {
        activityList.remove(activity);
    }

    // 遍历所有Activity并finish
    public void clear() {
        for (Activity activity : activityList) {
            activity.finish();
        }
        //System.exit(0);
    }
    public Activity getActivity(){
        if(activityList.size()>0)
            return activityList.get(activityList.size()-1);
        else
            return null;
    }

    public List<Activity> getActivityList(){
        return activityList;
    }

}
