package com.example.administrator.icome.icomeutils.utils;

import android.app.Activity;
import android.app.Application;

import java.util.LinkedList;
import java.util.List;

/**
 *
 *
 * 用于处理退出程序时可以退出所有的Activity，而编写的通用类
 * 每个Activity在oncreate的时候都需要调用AppManager.getInstance().addActivity(this);
 * 以便将当前Activity加入到Activity集合中
 *
 * 
 */
public class BaseAppManager extends Application {

	private List<Activity> activityList = new LinkedList<Activity>();
	private static BaseAppManager instance;

	private BaseAppManager() {
	}

	// 单例模式中获取唯一的AppManager实例
	public static BaseAppManager getInstance() {
		if (null == instance) {
			instance = new BaseAppManager();
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
