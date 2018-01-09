package com.example.latte.net;

import com.example.latte.net.callback.IError;
import com.example.latte.net.callback.IFailure;
import com.example.latte.net.callback.IRequest;
import com.example.latte.net.callback.ISuccess;

import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.RequestBody;

/**
 * Created by xushiyun on 2018/1/8.
 * Project Name: FastEc
 * Package Name: com.example.latte.net
 * File Name:    RestClient
 * Descripetion: Todo
 */

public class RestClient {

    private final String URL;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest IREQUEST;
    private final ISuccess ISUCCESS;
    private final IFailure IFAILURE;
    private final IError IERROR;
    private final RequestBody BODY;

    public RestClient(String URL,
                      Map<String, Object> PARAMS,
                      IRequest IREQUEST,
                      ISuccess ISUCCESS,
                      IFailure IFAILURE,
                      IError IERROR,
                      RequestBody BODY) {
        this.URL = URL;
        this.PARAMS.putAll(PARAMS);
        this.IREQUEST = IREQUEST;
        this.ISUCCESS = ISUCCESS;
        this.IFAILURE = IFAILURE;
        this.IERROR = IERROR;
        this.BODY = BODY;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }
}
