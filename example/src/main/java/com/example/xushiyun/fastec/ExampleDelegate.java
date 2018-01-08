package com.example.xushiyun.fastec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.latte.delegates.LatteDelegate;

/**
 * Created by xushiyun on 2018/1/8.
 * Project Name: FastEc
 * Package Name: com.example.xushiyun.fastec
 * File Name:    ExampleDelegate
 * Descripetion: Todo
 */

public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        //对每一个控件进行操作
    }
}
