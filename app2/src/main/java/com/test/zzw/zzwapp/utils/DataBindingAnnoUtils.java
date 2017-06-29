package com.test.zzw.zzwapp.utils;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.util.Log;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Administrator on 2017/6/5.
 */

public class DataBindingAnnoUtils {

    @BindingAdapter({"image"})
    public static void imageLoader(ImageView imageView, String url){
        Log.e("zzwdd", "zzwimageLoader: imageLoader---"+url);
        Picasso.with(imageView.getContext()).load(url).into(imageView);
//        DisplayImageOptions options = ImageLoaderUtils.initOptions();
//        ImageLoader.getInstance().displayImage(
//                url, imageView, options);

    }
    @BindingConversion
    public static String converData(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

}
