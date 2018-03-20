package com.example.latte.ui.banner;

import android.media.Image;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

/**
 * Created by xushiyun on 2018/3/20.
 * Project Name: FastEc
 * Package Name: com.example.latte.ui.banner
 * File Name:    HolderCreator
 * Description: Todo
 */

public class HolderCreator implements CBViewHolderCreator<ImageHolder> {
    @Override
    public ImageHolder createHolder() {
        return new ImageHolder();
    }
}
