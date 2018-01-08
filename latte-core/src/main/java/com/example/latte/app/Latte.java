package com.example.latte.app;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by xushiyun on 2018/1/7.
 * Project Name: FastEc
 * Package Name: com.example.latte.app
 * File Name:    Latte
 * Descripetion: Todo
 */

public final class Latte {

    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static HashMap<String, Object> getConfigurations() {
        return Configurator.getInstance().getLatteConfigs();
    }

    public static Context getApplicationContext() {
        return Configurator.getInstance().getConfiguration(ConfigType.APPLICATION_CONTEXT);
    }
}
