package com.example.xushiyun.fastec;

import android.app.Application;

import com.example.latte.app.Latte;

/**
 * Created by xushiyun on 2018/1/7.
 * Project Name: FastEc
 * Package Name: com.example.xushiyun.fastec
 * File Name:    ExampleApp
 * Descripetion: Todo
 */

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("http://127.0.0.1")
                .configure();
    }
}
