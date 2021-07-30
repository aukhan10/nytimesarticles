package com.droid.nytimes.common.util;

import android.content.Context;
import android.widget.ImageView;

import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.droid.nytimes.R;


public class ImageUtil {

    public static void loadImage(Context context, ImageView imageView, String imageURL) {
        CircularProgressDrawable cd = new CircularProgressDrawable(context);
        cd.setStrokeWidth(5f);
        cd.setCenterRadius(30f);
        cd.start();

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(cd)
                .error(R.drawable.ic_error_image);
        Glide.with(context).load(imageURL).apply(options).into(imageView);
    }
}