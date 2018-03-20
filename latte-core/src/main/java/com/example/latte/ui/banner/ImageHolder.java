package com.example.latte.ui.banner;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by xushiyun on 2018/3/20.
 * Project Name: FastEc
 * Package Name: com.example.latte.ui.banner
 * File Name:    ImageHolder
 * Description: Todo
 */

public class ImageHolder implements Holder<String> {

    private AppCompatImageView mImageView = null;
    private static final RequestOptions REQUEST_OPTIONS =
            new RequestOptions()
                    .centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)
                    .dontAnimate();

    @Override
    public View createView(Context context) {

        mImageView = new AppCompatImageView(context);
        return mImageView;
    }

    @Override
    public void UpdateUI(Context context, int position, String data) {
        Glide.with(context)
                .load(data)
                .apply(REQUEST_OPTIONS)
                .into(mImageView);
    }

}
