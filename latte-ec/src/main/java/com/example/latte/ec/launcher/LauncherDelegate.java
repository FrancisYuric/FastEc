package com.example.latte.ec.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.latte.R2;
import com.example.latte.delegates.LatteDelegate;
import com.example.latte.ec.R;

import butterknife.BindView;

/**
 * Created by xushiyun on 2018/1/10.
 * Project Name: FastEc
 * Package Name: com.example.latte.ec.launcher
 * File Name:    Launcher
 * Descripetion: Todo
 */

public class LauncherDelegate extends LatteDelegate {

//    @BindView(R2.id.tv_launcher_timer)

    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
