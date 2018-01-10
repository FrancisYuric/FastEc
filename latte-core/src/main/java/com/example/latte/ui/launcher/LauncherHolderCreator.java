package com.example.latte.ui.launcher;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

/**
 * Created by xushiyun on 2018/1/10.
 * Project Name: FastEc
 * Package Name: com.example.latte.ui.launcher
 * File Name:    LauncherHolderCreator
 * Descripetion: Todo
 */

public class LauncherHolderCreator implements CBViewHolderCreator<LauncherHolder> {
    @Override
    public LauncherHolder createHolder() {
        return new LauncherHolder();
    }
}
