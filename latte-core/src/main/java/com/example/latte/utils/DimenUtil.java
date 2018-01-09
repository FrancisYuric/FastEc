package com.example.latte.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.example.latte.app.Latte;

/**
 * Created by xushiyun on 2018/1/9.
 * Project Name: FastEc
 * Package Name: com.example.latte.utils
 * File Name:    DimenUtil
 * Descripetion: Todo
 */

public class DimenUtil {

    public static int getScreenWidth() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }

}
