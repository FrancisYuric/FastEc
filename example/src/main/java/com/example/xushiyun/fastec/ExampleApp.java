package com.example.xushiyun.fastec;

import android.app.Application;

import com.example.latte.app.Latte;
import com.example.latte.ec.database.DatabaseManager;
import com.example.latte.ec.icon.FontEcModule;
import com.example.latte.net.interceptors.DebugInterceptor;
import com.facebook.stetho.Stetho;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;

/**
 * Created by xushiyun on 2018/1/7.
 * Project Name: FastEc
 * Package Name: com.example.xushiyun.fastec
 * File Name:    ExampleApp
 * Description: Todo
 */

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://127.0.0.1")
                .withInterceptor(new DebugInterceptor("user_profile", R.raw.user_profile))

                .configure();


        //greenDao数据初始化
        DatabaseManager.getInstance().init(this);

        //SQLiteStudioRemote初始化
        SQLiteStudioService.instance().start(this);

        //Logger初始化
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    private void initStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }
}
