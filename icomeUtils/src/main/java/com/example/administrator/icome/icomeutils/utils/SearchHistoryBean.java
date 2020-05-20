package com.example.administrator.icome.icomeutils.utils;

/**
 * Created by Administrator on 2018/1/16.
 */

public class SearchHistoryBean {
    private String time;
    private String content;

    public SearchHistoryBean() {
    }

    public SearchHistoryBean(String time, String content) {

        this.content = content;
        this.time = time;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
