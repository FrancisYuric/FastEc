package com.example.latte.net.callback;


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

    public RequestCallbacks(IRequest request, ISuccess success, IFailure failure, IError error) {
        this.IREQUEST = request;
        this.ISUCCESS = success;
        this.IFAILURE = failure;
        this.IERROR = error;
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
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if(IFAILURE != null) {
            IFAILURE.onFailure();
        }

        if(IREQUEST != null) {
            IREQUEST.onRequestEnd();
        }
    }
}
