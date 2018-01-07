package com.example.latte.app;

import android.support.v7.widget.ContentFrameLayout;

import java.util.HashMap;

/**
 * Created by xushiyun on 2018/1/7.
 * Project Name: FastEc
 * Package Name: com.example.latte.app
 * File Name:    Configurator
 * Descripetion: Todo
 */

public final class Configurator {
    private static final HashMap<String, Object> LATTE_CONFIGS = new HashMap<>();

    private Configurator() {
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    private static final class Holder{
        private final static Configurator INSTANCE = new Configurator();
    }

    public final void configure() {
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    final HashMap<String, Object> getLatteConfigs() {
        return LATTE_CONFIGS;
    }

    public final Configurator withApiHost(String host) {
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    private void checkConfiguration() {
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if(!isReady) {
            throw new RuntimeException("Configuration is not ready, call configure");
        }
    }


    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key) {
        checkConfiguration();
        return (T) LATTE_CONFIGS.get(key.name());
    }
}
