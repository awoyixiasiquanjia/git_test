package com.example.administrator.icome.icomeutils.utils;

import android.app.Activity;
import android.text.TextUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by lishuai on 2019/5/8.
 * 根据Url查询title和icon的工具类
 */

public class QueryUrlTitleUtils {

    public static void backUrlBean(final Activity activity, final String url, final SendUrlIntrBan sendUrlIntrBan) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final UrlTitleBean urlTitleBean = queryUrlBean(url);
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        sendUrlIntrBan.sendUrlBean(urlTitleBean);
                    }
                });
            }
        }).start();
    }

    /**
     * 通过 传入的url 获取 title 和image
     *
     * @param url
     * @return
     */
    public static UrlTitleBean queryUrlBean(String url) {
        if (!TextUtils.isEmpty(url) && !url.contains("http")) {
            url = "http://" + url;
        }
        String imgStr = null, titleName = null;
        try {
            Document doc = Jsoup.connect(url).get();
            Element elementById = doc.getElementById("activity-name");//微信的title单独处理
            if (elementById != null) {
                titleName = elementById.text();//获取标签的内容
            } else {
                titleName = doc.title();
            }
//            Elements imgs = doc.getElementsByTag("img");//取得所有Img标签的值
//            if (imgs.size() > 0) {
//                imgStr = imgs.get(0).attr("abs:src");//默认取第一个为图片
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new UrlTitleBean(url, getUrlHost(url), titleName);
    }

    /**
     * 通过接口返回一个实体Bena
     */
    public interface SendUrlIntrBan {
        void sendUrlBean(UrlTitleBean urlTitleBean);
    }

    /**
     * 包含title和image的Bean
     */
    public static class UrlTitleBean implements Serializable {
        String imageUrl, titleName, urlLink;

        public UrlTitleBean(String url, String imageUrl, String titleName) {
            this.urlLink = url;
            this.imageUrl = imageUrl;
            this.titleName = titleName;
        }

        public String getUrlLink() {
            return urlLink;
        }

        public void setUrlLink(String urlLink) {
            this.urlLink = urlLink;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getTitleName() {
            return titleName;
        }

        public void setTitleName(String titleName) {
            this.titleName = titleName;
        }
    }

    /**
     * 获取网址的host工具
     *
     * @param url
     * @return
     */
    public static String getUrlHost(String url) {
        String host = null;
        try {
            URL myUrl = new URL(url);
            host = "http://" + myUrl.getHost() + "/favicon.ico";
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return host;
    }
}
