package com.example.xushiyun.fastec;

import android.app.Application;

import com.example.latte.app.Latte;
import com.example.latte.ec.database.DatabaseManager;
import com.example.latte.ec.icon.FontEcModule;
import com.example.latte.net.interceptors.DebugInterceptor;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

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
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://127.0.0.1")
                .withInterceptor(new DebugInterceptor("index",R.raw.test))
                .configure();

        //greenDao数据初始化
        DatabaseManager.getInstance().init(this);
    }
}
