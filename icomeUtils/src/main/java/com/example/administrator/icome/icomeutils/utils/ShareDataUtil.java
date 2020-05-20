package com.example.administrator.icome.icomeutils.utils;


import android.content.Context;

public class ShareDataUtil {
    public static final String TOKEN = "token";
    public static final String ISLOGIN = "isLogin";
    public static final String SEARCH_TYPE = "searchType";
    public static final String SEARCH_RESULT_TYPE = "searchResultType";
    public static final String LOGIN_NAME = "loginName";
    public static final String PASSWORD = "password";
    public static final String SP_USER_ID = "userId";
    public static final String SP_TICKET = "ticket";
    public static final String SP_E_NAME = "ename";
    public static final String SP_City_NAME = "cityName";
    public static final String SP_GENDER = "genser";
    public static final String SP_TEAMID = "teamId";//组织id
    public static final String SP_TEAMNAME = "teamName";//组织名字
    public static final String VERSION_CODE = "versionCode";//版本号
    public static final String GENSTURE_STATUS = "genstureStatue";//手势状态
    public static final String INTER_WEB_TIME = "inter_web_time";//手势密码间隔
    public static final String IS_SHOW_GESTURE_DIALOG = "is_show_gesture_dailog";

    public static final String PHOTO_ID = "photoId";
    public static final String ACCOUNT ="account";
    public static final String QUESTIONS_AND_ANSWERS = "questions_and_answers";//问答页面链接
    public static final String VALUE_SHARE_URL = "vale_share_url";//创值分享链接

    public static final String TICKET_LONG="ticket_long";//miniappbaseurl
    public static final String TOKEN_EXPIRATION="token_expiration";//miniappbaseurl
    public static final String SP_ONAME = "oName";//工作地址
    public static final String SP_JOBTITLE = "jobTitle";//职位
    public static final String WORKBENCH_REPLY_ISFOLD = "WORKBENCH_REPLY_ISFOLD";
    public static final String VERSION = "version";
    public static final String UPARADE_WAY = "upgradeWay";
    public static final String UPARADE_LOG = "upgradeLog";
    public static final String DOWNLOAD_ADDR = "downloadAddr";
    public static final String PACKAGE_NAME = "packageName";



















    /**
     * 获取token
     *
     * @param context
     * @return
     */
    public static String getToken(Context context) {
        return SharedPreferencesUtils.getStringShareData(context, TOKEN);
    }



    public static String getUserId(Context context) {
        return SharedPreferencesUtils.getStringShareData(context, SP_USER_ID);
    }

    public static String getTicket(Context context) {
        return SharedPreferencesUtils.getStringShareData(context, SP_TICKET);
    }

    public static void putTicket(Context context,String ticket){
        SharedPreferencesUtils.putStringShareData(context,SP_TICKET, ticket);
    }



    public static String getEname(Context context) {
        return SharedPreferencesUtils.getStringShareData(context, SP_E_NAME);
    }



    public static String getTeamId(Context context) {
        return SharedPreferencesUtils.getStringShareData(context, SP_TEAMID);
    }

    public static String getTeamName(Context context) {
        return SharedPreferencesUtils.getStringShareData(context, SP_TEAMNAME);
    }


    /**
     * @author caozhuangzhuang
     * @email 1063841764@qq.com
     * @create 2019/6/26 11:58
     * @description 获取问答页面url
     * @param
     * @return
     */
    public static String getQuestionsUrl(Context context) {
        return SharedPreferencesUtils.getStringShareData(context, QUESTIONS_AND_ANSWERS);
    }

    /**
     * @author caozhuangzhuang
     * @email 1063841764@qq.com
     * @create 2019/6/26 12:15
     * @description 获取价值分享url
     * @param
     * @return
     */
    public static String getValueShareUrl(Context context) {
        return SharedPreferencesUtils.getStringShareData(context, VALUE_SHARE_URL);
    }
}
