package com.example.administrator.icome.icomeutils.utils;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 */
public class StrUtils {
    //用于判断@xxx 字段
    private static String atRegEx = "@[^@]*[\u2005]";

    /**
     * 是否包含@
     *
     * @param content
     * @return
     */
    public static boolean isHasAt(String content) {
        Pattern pattern = Pattern.compile(atRegEx);
        Matcher matcher = pattern.matcher(content);
        return matcher.matches();
    }

    /**
     * 设置At字符串颜色
     *
     * @param content
     * @return
     */
    public static SpannableString changeColor2At(String content, int color) {
        Pattern pattern = Pattern.compile(atRegEx);
        Matcher matcher = pattern.matcher(content);
        SpannableString sStr = new SpannableString(content);
        while (matcher.find()) {
            String group = matcher.group();
            //设置字体前景色
            sStr.setSpan(new ForegroundColorSpan(color), matcher.start(), matcher.end(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        return sStr;
    }

    /**
     * 设置字体颜色
     *
     * @param content param  regStr
     * @param color
     */
    public static SpannableString changeFontColor(String content, String[] regStr, int color) {
        SpannableString sStr = new SpannableString(content);
        for(int i = 0;i<regStr.length;i++){
            Pattern pattern = Pattern.compile(regStr[i]);
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()) {
                String group = matcher.group();
                //设置字体前景色
                sStr.setSpan(new ForegroundColorSpan(color), matcher.start(), matcher.end(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        /*SpannableString sStr = new SpannableString(content);
        for (int i = 0; i < regStr.length; i++) {
            sStr.setSpan(new ForegroundColorSpan(color), content.indexOf(regStr[i]), content.indexOf(regStr[i]) + regStr[i].length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }*/
        return sStr;

    }

    /**
     * 设置字体颜色并加粗
     *
     * @param content
     * @param regStr
     * @param color
     * @return
     */
    public static SpannableString changeFontColorAndBold(String content, String[] regStr, int color) {
        SpannableString sStr = new SpannableString(content);
        for (int i = 0; i < regStr.length; i++) {
            sStr.setSpan(new ForegroundColorSpan(color), content.indexOf(regStr[i]), content.indexOf(regStr[i]) + regStr[i].length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            sStr.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), content.indexOf(regStr[i]), content.indexOf(regStr[i]) + regStr[i].length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //粗体
        }
        return sStr;

    }

    /**
     * 设置字体颜色
     *
     * @param content
     * @param color
     */
    public static SpannableString changeFontColor(String content, int color) {
        SpannableString sStr = new SpannableString(content);
        sStr.setSpan(new ForegroundColorSpan(color), 0, content.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sStr;

    }

    /**
     * @param url
     * @param ticket 跳转h5详情替换ticket
     * @return
     */
    public static String replaceWorkbench(String url, String ticket) {
        return url.replace("{ticket}", ticket);
    }

    /**
     * @param url
     * @param ticket 跳转h5详情拼ticket
     * @return
     */
    public static String addWorkbench(String url, String ticket) {
        return url + "&ticket=" + ticket;
    }
}
