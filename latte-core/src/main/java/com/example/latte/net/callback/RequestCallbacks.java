package com.example.latte.net.callback;


import android.os.Handler;

import com.example.latte.ui.loader.LatteLoader;
import com.example.latte.ui.loader.LoaderStyle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by xushiyun on 2018/1/9.
 * Project Name: FastEc
 * Package Name: com.example.latte.net.callback
 * File Name:    RequestCallbacks
 * Descripetion: Todo
 */

public class RequestCallbacks implements Callback<String> {
    private final IRequest IREQUEST;
    private final ISuccess ISUCCESS;
    private final IFailure IFAILURE;
    private final IError IERROR;
    private final LoaderStyle LOADER_STYLE;
    private final static Handler HANDLER = new Handler();

    public RequestCallbacks(IRequest request, ISuccess success, IFailure failure, IError error,
        LoaderStyle style) {
        this.IREQUEST = request;
        this.ISUCCESS = success;
        this.IFAILURE = failure;
        this.IERROR = error;
        this.LOADER_STYLE = style;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if(response.isSuccessful()) {
            if(call.isExecuted()) {
                if(ISUCCESS != null) {
                    ISUCCESS.onSuccess(response.body());
                }
            }
        }
        else {
            if(IERROR != null) {
                IERROR.onError(response.code(), response.message());
            }
        }
        stopLoading();
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if(IFAILURE != null) {
            IFAILURE.onFailure();
        }

        if(IREQUEST != null) {
            IREQUEST.onRequestEnd();
        }
        stopLoading();
    }

    private void stopLoading() {
        if(LOADER_STYLE != null) {
            HANDLER.postDelayed(new Runnable() {
                @Override
                public void run() {
                    LatteLoader.stopLoading();
                }
            },1000);
        }
    }
}
