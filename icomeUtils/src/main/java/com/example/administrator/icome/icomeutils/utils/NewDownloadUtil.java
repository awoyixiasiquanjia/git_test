package com.example.administrator.icome.icomeutils.utils;

import android.support.annotation.NonNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NewDownloadUtil {

    private static NewDownloadUtil downloadUtil;
    private final OkHttpClient okHttpClient;
    private Call calll;


    public static NewDownloadUtil get() {
        if (downloadUtil == null) {
            downloadUtil = new NewDownloadUtil();
        }
        return downloadUtil;
    }

    /**
     * 取消下载
     */
    public void cancleDawnLoad() {
        if (calll != null) {
            calll.cancel();
        }
    }

    public NewDownloadUtil() {
        okHttpClient = new OkHttpClient();
    }

    /**
     * @param url      下载连接
     * @param saveDir  储存下载文件的SDCard目录
     * @param listener 下载监听
     */
    public void download(final String url, final String filename, final String saveDir, final OnDownloadListener listener) {
        Request request = new Request.Builder().url(url).build();
        calll = okHttpClient.newCall(request);
        calll.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // 下载失败
                listener.onDownloadFailed();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream is = null;
                byte[] buf = new byte[2048];
                int len = 0;
                FileOutputStream fos = null;
                // 储存下载文件的目录
                String savePath = isExistDir(saveDir);
                try {
                    is = response.body().byteStream();
                    long total = response.body().contentLength();
                    File file = new File(savePath, filename);
                    fos = new FileOutputStream(file);
                    long sum = 0;
                    while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                        sum += len;
                        int progress = (int) (sum * 1.0f / total * 100);
                        // 下载中
                        listener.onDownloading(progress);
                    }
                    fos.flush();
                    // 下载完成

                    listener.onDownloadSuccess();

                } catch (Exception e) {
                    if (e instanceof SocketException) {//取消请求
//                        listener.cancleDownLoad();
                    } else {
                        listener.onDownloadFailed();
                    }
                } finally {
                    try {
                        if (is != null)
                            is.close();
                    } catch (IOException e) {
                    }
                    try {
                        if (fos != null)
                            fos.close();
                    } catch (IOException e) {
                    }
                }
            }
        });
    }

    /**
     * @param saveDir
     * @return
     * @throws IOException 判断下载目录是否存在
     */
    private String isExistDir(String saveDir) throws IOException {
        // 下载位置
        File downloadFile = new File(saveDir);
        if (!downloadFile.mkdirs()) {
            downloadFile.createNewFile();
        }
        String savePath = downloadFile.getAbsolutePath();
        return savePath;
    }

    /**
     * @param url
     * @return 从下载连接中解析出文件名
     */
    @NonNull
    private String getNameFromUrl(String url) {
        return url.substring(url.lastIndexOf("/") + 1);
    }

    public interface OnDownloadListener {
        /**
         * 下载成功
         */
        void onDownloadSuccess();

        /**
         * @param progress 下载进度
         */
        void onDownloading(int progress);

        /**
         * 下载失败
         */
        void onDownloadFailed();

        /**
         * 取消下载
         */
       // void cancleDownLoad();
    }
}