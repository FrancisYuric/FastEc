package com.example.latte.net;

import com.example.latte.app.ConfigType;
import com.example.latte.app.Latte;

import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by xushiyun on 2018/1/8.
 * Project Name: FastEc
 * Package Name: com.example.latte.net
 * File Name:    RestCreator
 * Descripetion: Todo
 */

public class RestCreator {

    private static final class ParamsHolder {
        public static final WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();
    }

    public static WeakHashMap<String, Object> getParams() {
        return ParamsHolder.PARAMS;
    };

    public static RestService getRestService() {
        return RestServiceHolder.REST_SERVICE;
    }

    private static final class RetrofitHolder {
        private static final String BASE_URL = (String) Latte.getConfigurations().get(ConfigType.API_HOST.name());
        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OKHttpHolder.okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    private static final class OKHttpHolder {
        private static final int TIME_OUT = 60;
        private static final OkHttpClient.Builder BUILDER= new OkHttpClient.Builder();
        private static final ArrayList<Interceptor> INTERCEPTORS = Latte.getConfiguration(ConfigType.INTERCEPTOR.name());
        private static OkHttpClient.Builder addInterceptor() {
            if(INTERCEPTORS != null && !INTERCEPTORS.isEmpty()) {
                for (Interceptor interceptor: INTERCEPTORS) {
                    BUILDER.addInterceptor(interceptor);
                }
            }
            return BUILDER;
        }

        private static final OkHttpClient okHttpClient = addInterceptor()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    private static final class RestServiceHolder {
        private static final RestService REST_SERVICE = RetrofitHolder.RETROFIT_CLIENT
                .create(RestService.class);
    }
}
