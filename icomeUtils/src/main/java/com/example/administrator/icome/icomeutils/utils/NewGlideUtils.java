package com.example.administrator.icome.icomeutils.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.signature.StringSignature;
import com.example.administrator.icome.icomeutils.R;

import java.util.concurrent.ExecutionException;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by wanye on 2018/12/12.
 * The mailbox is 15601356630@163.com
 */

public class NewGlideUtils {

    /**
     * 普通的加载图片的方法
     *
     * @param context
     * @param url
     * @param view
     */
    public static void loadImage(Context context, String url, ImageView view) {
        Glide.with(context)
                .load(url)
                .placeholder(R.mipmap.career_home_default_img)
                .error(R.mipmap.career_home_default_img)
                .centerCrop()
                .into(view);
    }

    /**
     * i小来表情的加载图片的方法
     *
     * @param context
     * @param url
     * @param view
     */
    public static void iEmojiLoadImage(Context context, String url, ImageView view) {
        Glide.with(context)
                .load(url)
                .placeholder(R.mipmap.i_robot)
                .error(R.mipmap.i_robot)
                .dontAnimate()   //解决Glide 加载图片缓慢（第一次加载不出来图片）的Bug  加上 .dontAnimate()
                .centerCrop()
                .into(view);
    }

    /**
     * 普通的加载图片的方法
     *
     * @param context
     * @param url
     * @param view
     */
    public static void loadImage(Context context, String url, ImageView view, int resourceId) {
        Glide.with(context)
                .load(url)
                .placeholder(resourceId)
                .error(resourceId)
                .centerCrop()
                .dontAnimate()
                .into(view);
    }

    /**
     * 加载动图的方法
     *
     * @param context
     * @param url
     * @param view
     */
    public static void loadGifImage(Context context, String url, ImageView view) throws ExecutionException, InterruptedException {
//        Glide.with(context.getApplicationContext())
//                .load(url)
//                .asGif()
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                .error(R.mipmap.career_home_default_img)
//                .centerCrop()
//                .into(view);
//        GifDrawable gifFromFile = new GifDrawable(gifFile);

    }

    /**
     * 使用Glide切圆角图片,根据image大小，自动从中心裁剪图片
     *
     * @param context
     * @param urlString 图片地址
     * @param imageView
     * @param i         圆角大小
     */

    public static void glideNewCircular(Context context, String urlString, ImageView imageView, int i) {
        Glide.with(context)
                .load(urlString)
                .error(R.mipmap.noimage)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .crossFade()
                .transform(new CenterCrop(context)
                        , new GlideRoundImage(context, i))
                .into(imageView);
    }

    /**
     * 使用Glide加载圆形图片
     *
     * @param context
     * @param urlString
     * @param imageView
     */
    public static void glideNewClrcle(Context context, String urlString, ImageView imageView) {

        Glide.with(context)
                .load(urlString)
                .bitmapTransform(new CropCircleTransformation(context))
                .placeholder(R.mipmap.headimage)
                .error(R.mipmap.headimage)
                .signature(new StringSignature(String.valueOf(System.currentTimeMillis())))
                //不使用缓存的图片
                .into(imageView);
    }

    /**
     * 使用Glide加载圆形图片
     * 此处避免glide动画闪烁问题
     * @param context
     * @param urlString
     * @param imageView
     */
    public static void glideMeetClrcle(Context context, String urlString, ImageView imageView) {

        Glide.with(context)
                .load(urlString)
                .bitmapTransform(new CropCircleTransformation(context))
                .error(R.mipmap.headimage)
                .placeholder(R.mipmap.headimage)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .signature(new StringSignature(String.valueOf("1111111")))
                .into(imageView);
    }

    /**
     * 使用Glide加载圆形图片不要默认图
     *
     * @param context
     * @param urlString
     * @param imageView
     */
    public static void glideNewClrcleNoError(Context context, String urlString, ImageView imageView) {

        Glide.with(context)
                .load(urlString)
                .bitmapTransform(new CropCircleTransformation(context))
                .signature(new StringSignature(String.valueOf(System.currentTimeMillis())))
                //不使用缓存的图片
                .into(imageView);
    }

    /**
     * 使用Glide切圆角图片,图片太大会压缩图片
     *
     * @param context
     * @param urlString 图片地址
     * @param imageView
     * @param i         圆角大小
     */

    public static void glideCircularBead2(Context context, String urlString, ImageView imageView, int i) {
        Glide.with(context)
                .load(urlString)
                .placeholder(R.mipmap.headimage)
                .error(R.mipmap.headimage)
                .centerCrop()
                .bitmapTransform(new CropCircleTransformation(context))
                .into(imageView);
    }
    /**
     * 使用Glide切圆角图片,图片太大会压缩图片
     *
     * @param context
     * @param urlString 图片地址
     * @param imageView
     */

    public static void glideCircleWithSig(Context context, String urlString, String signature,ImageView imageView) {

        Glide.with(context)
                .load(urlString)
                .placeholder(R.mipmap.headimage)
                .bitmapTransform(new CropCircleTransformation(context))
                .signature(new StringSignature(signature))
                .into(imageView);
//
    }

    /**
     * 使用Glide切圆角图片,根据image大小，自动从中心裁剪图片
     *
     * @param context
     * @param urlString 图片地址
     * @param imageView
     * @param i         圆角大小
     */

    public static void glideCircularBead3(Context context, String urlString, ImageView imageView, int i) {
        Glide.with(context)
                .load(urlString)
                .error(R.mipmap.headimage)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .crossFade()
                .transform(new CenterCrop(context)
                        , new GlideRoundImage(context, i))
                .into(imageView);
    }

    public static void loadMediaBitmapOfDynamic(Context context, String url, ImageView view, int radius, int resourceId) {
        if (null != context && !TextUtils.isEmpty(url) && null != view) {
            if (View.VISIBLE != view.getVisibility()) {
                view.setVisibility(View.VISIBLE);
            }

            Glide.with(context)
                    .load(url)
                    .placeholder(resourceId)
                    .error(resourceId)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .skipMemoryCache(true)
                    .bitmapTransform(new CenterCrop(context), new RoundedCornersTransformation(context, radius, 0, RoundedCornersTransformation.CornerType.ALL))
//                    .dontAnimate()
                    .into(view);
        }
    }

    public static void loadMediaBitmapOfDynamic(Context context, String url, ImageView view, int radius, int resourceId, RoundedCornersTransformation.CornerType cornerType) {
        if (null != context && !TextUtils.isEmpty(url) && null != view) {
            if (View.VISIBLE != view.getVisibility()) {
                view.setVisibility(View.VISIBLE);
            }

            Glide.with(context)
                    .load(url)
                    .placeholder(resourceId)
                    .error(resourceId)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .skipMemoryCache(true)
                    .bitmapTransform(new CenterCrop(context), new RoundedCornersTransformation(context, radius, 0, cornerType))
//                    .dontAnimate()
                    .into(view);
        }
    }

    /**
     * 使用Glide加载矩形图片
     */
    public static void loadRectBitmap(Context context, String url, ImageView view) {
        if (null != context && !TextUtils.isEmpty(url) && null != view) {
            if (View.VISIBLE != view.getVisibility()) {
                view.setVisibility(View.VISIBLE);
            }
            Glide.with(context)
                    .load(url)
                    .placeholder(R.mipmap.career_home_default_img)
                    .error(R.mipmap.career_home_default_img)
                    .centerCrop()
                    .into(view);
        }
    }

    /**
     * 使用Glide切圆角图片,根据image大小，自动从中心裁剪图片
     *
     * @param context
     * @param urlString 图片地址
     * @param imageView
     * @param i         圆角大小
     */
    public static void loadFilletBitmap(Context context, String urlString, ImageView imageView, int i) {
        Glide.with(context)
                .load(urlString)
                .error(R.mipmap.career_home_default_img)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .crossFade()
                .transform(new CenterCrop(context)
                        , new GlideRoundImage(context, i))
                .into(imageView);
    }

    /**
     * 使用Glide切圆角图片,根据image大小，自动从中心裁剪图片
     *
     * @param context
     * @param urlString 图片地址
     * @param imageView
     */
    public static void loadFilletBitmap(Context context, String urlString, ImageView imageView) {
        loadFilletBitmap(context, urlString, imageView, 4);
    }
    /**
     * 创值链加载图片调用方法
     *
     * @param context
     * @param urlString 图片地址
     * @param imageView
     * @param i         圆角大小
     */
    public static void loadValueChainBitmap(Context context, String urlString,int resource, ImageView imageView, int i) {
        Glide.with(context)
                .load(urlString)
//                .placeholder(resource)
                .error(resource)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .crossFade()
                .transform(new CenterCrop(context)
                        , new GlideRoundImage(context, i))
                .into(imageView);
    }
    /**
     * 创值链加载图片
     *
     * @param context
     * @param urlString 图片地址
     * @param imageView
     */
    public static void loadValueChainBitmap(Context context,  String urlString, ImageView imageView) {
        loadValueChainBitmap(context, urlString,R.mipmap.img_value_chain_square_default, imageView, 4);
    }

    /**
     * 使用Glide加载高斯模糊图
     *
     * @param context
     * @param urlString
     * @param imageView
     */
    public static void glideBlurBitmap(Context context, String urlString, ImageView imageView) {

        Glide.with(context)
                .load(urlString)
                .bitmapTransform(new BlurTransformation(context,16))
                .crossFade(1000)
                .error(R.mipmap.headimage)
//                .centerCrop()
                .signature(new StringSignature(String.valueOf(System.currentTimeMillis())))
                //不使用缓存的图片
                .into(imageView);
    }
}
