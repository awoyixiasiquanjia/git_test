package com.example.administrator.icome.icomeutils.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：james on 2018/1/15 15:19
 */
public class SharedPreferencesUtils {
    private static SharedPreferences sp = null;

    /**
     * 获取boolean值
     */
    public static boolean getBooleanShareData(Context mContext, String key) {
        SPSave_Current spSave_current = SPSave_Current.getSPSave_Current(mContext);
        sp = mContext.getSharedPreferences(spSave_current.getSP("mobile"), Context.MODE_PRIVATE);
        return sp.getBoolean(key, false);
    }

    /**
     * 获取boolean值,增加默认值参数
     *
     * @param mContext
     * @param key
     * @param defValue
     * @return
     */
    public static boolean getBooleanShareData(Context mContext, String key, boolean defValue) {
        SPSave_Current spSave_current = SPSave_Current.getSPSave_Current(mContext);
        sp = mContext.getSharedPreferences(spSave_current.getSP("mobile"), Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }

    /**
     * 删除
     *
     * @param key
     */
    public static void romoveBooleanShareData(Context mContext, String key) {
        SPSave_Current spSave_current = SPSave_Current.getSPSave_Current(mContext);
        sp = mContext.getSharedPreferences(spSave_current.getSP("mobile"), Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.remove(key);
        edit.commit();
    }

    /**
     * 保存boolean
     */
    public static void putBooleanShareData(Context mContext, String key, boolean value) {
        SPSave_Current spSave_current = SPSave_Current.getSPSave_Current(mContext);
        sp = mContext.getSharedPreferences(spSave_current.getSP("mobile"), Context.MODE_PRIVATE);
        SharedPreferences.Editor et = sp.edit();
        et.putBoolean(key, value);
        et.commit();
    }

    /**
     * 保存string
     */
    public static void putStringShareData(Context mContext, String key, String value) {
        SPSave_Current spSave_current = SPSave_Current.getSPSave_Current(mContext);
        sp = mContext.getSharedPreferences(spSave_current.getSP("mobile"), Context.MODE_PRIVATE);
        SharedPreferences.Editor et = sp.edit();
        et.putString(key, value);
        et.commit();
    }

    /**
     * 获取string，默认值为""
     *
     * @param key
     * @return
     */
    public static String getStringShareData(Context mContext, String key) {
        SPSave_Current spSave_current = SPSave_Current.getSPSave_Current(mContext);
        sp = mContext.getSharedPreferences(spSave_current.getSP("mobile"), Context.MODE_PRIVATE);
        return sp.getString(key, "");
    }


    /**
     * 保存Long
     */
    public static void puLongShareData(Context mContext, String key, Long value) {
        SPSave_Current spSave_current = SPSave_Current.getSPSave_Current(mContext);
        sp = mContext.getSharedPreferences(spSave_current.getSP("mobile"), Context.MODE_PRIVATE);
        SharedPreferences.Editor et = sp.edit();
        et.putLong(key, value);
        et.commit();
    }

    /**
     * 获取Long，默认值为""
     *
     * @param key
     * @return
     */
    public static long getLongShareData(Context mContext, String key) {
        SPSave_Current spSave_current = SPSave_Current.getSPSave_Current(mContext);
        sp = mContext.getSharedPreferences(spSave_current.getSP("mobile"), Context.MODE_PRIVATE);
        return sp.getLong(key, 0);
    }


    public static void putIntShareData(Context mContext, String key, int value) {
        SPSave_Current spSave_current = SPSave_Current.getSPSave_Current(mContext);
        sp = mContext.getSharedPreferences(spSave_current.getSP("mobile"), Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt(key, value);
        edit.commit();
    }

    /**
     * 获取Int
     *
     * @param key
     * @param defValue
     * @return
     */
    public static int getIntShareData(Context mContext, String key, int defValue) {
        SPSave_Current spSave_current = SPSave_Current.getSPSave_Current(mContext);
        sp = mContext.getSharedPreferences(spSave_current.getSP("mobile"), Context.MODE_PRIVATE);
        return sp.getInt(key, defValue);
    }

    /**
     * 保存List
     *
     * @param tag
     * @param datalist
     */
    public static <T> void putDataList(Context mContext, String tag, List<T> datalist) {
        if (null == datalist || datalist.size() <= 0)
            return;

        Gson gson = new Gson();
        //转换成json数据，再保存
        String strJson = gson.toJson(datalist);
        SPSave_Current spSave_current = SPSave_Current.getSPSave_Current(mContext);
        sp = mContext.getSharedPreferences(spSave_current.getSP("mobile"), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
//        editor.clear();
        editor.putString(tag, strJson);
        editor.commit();

    }

    /**
     * 获取List
     *
     * @param tag
     * @return
     */
    public static <T> List<T> getDataList(Context mContext, String tag) {
        SPSave_Current spSave_current = SPSave_Current.getSPSave_Current(mContext);
        sp = mContext.getSharedPreferences(spSave_current.getSP("mobile"), Context.MODE_PRIVATE);
        List<T> datalist = new ArrayList<T>();
        String strJson = sp.getString(tag, null);
        if (null == strJson) {
            return datalist;
        }
        Gson gson = new Gson();
        datalist = gson.fromJson(strJson, new TypeToken<List<T>>() {
        }.getType());
        return datalist;
    }

    public static <T> List<T> getObjectList(Context mContext, String tag, Class<T> cls) {
        List<T> datalist = new ArrayList<T>();
        try {
            SPSave_Current spSave_current = SPSave_Current.getSPSave_Current(mContext);
            sp = mContext.getSharedPreferences(spSave_current.getSP("mobile"), Context.MODE_PRIVATE);
            String strJson = sp.getString(tag, null);
            if (null == strJson) {
                return datalist;
            }
            Gson gson = new Gson();
            JsonArray arry = new JsonParser().parse(strJson).getAsJsonArray();
            for (JsonElement jsonElement : arry) {
                datalist.add(gson.fromJson(jsonElement, cls));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datalist;
    }

    /**
     *
     * @param context
     * @param historyName 存储历史记录的key
     * @param key 存储单个记录
     */
    public static void putHistory(Context context,String historyName,String key){
        SPSave_Current spSave_current = SPSave_Current.getSPSave_Current(context);
        //获取之前存储的
        String old_text = spSave_current.getSP(historyName);
        if (!old_text.contains(key + ",")) {
            spSave_current.setSP(historyName,key + ","+old_text);
        }
    }

    /**
     *
     * @param context
     * @param historyName 存储历史记录的key
     * @param index 获取的历史长度
     * @return
     */
    public static List<String> getHistory(Context context,String historyName,int index){
        int i=0;
        ArrayList<String> list = new ArrayList<>();
        SPSave_Current spSave_current = SPSave_Current.getSPSave_Current(context);
        String old_text = spSave_current.getSP(historyName);

        if (!TextUtils.isEmpty(old_text)){
            String[] split = old_text.split(",");
            for (String string:split) {
                if (i<index){
                    list.add(string);
                    i++;
                }else {
                    break;
                }
            }
        }
        return list;
    }

    /**
     * 清除存储历史
     * @param context
     * @param historyName 存储历史记录的key
     */
    public static void cleanHistory(Context context,String historyName){
        SPSave_Current spSave_current = SPSave_Current.getSPSave_Current(context);
        spSave_current.setSP(historyName,"");
    }


}