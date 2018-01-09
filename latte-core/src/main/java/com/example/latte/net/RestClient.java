package com.example.latte.net;

import com.example.latte.net.callback.IError;
import com.example.latte.net.callback.IFailure;
import com.example.latte.net.callback.IRequest;
import com.example.latte.net.callback.ISuccess;
import com.example.latte.net.callback.RequestCallbacks;

import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

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

    private void request(HttpMethod method) {
        final RestService service = RestCreator.getRestService();
        Call<String> call = null;

        if(IREQUEST != null) {
            IREQUEST.onRequestStart();
        }

        switch (method) {
            case GET:
                call = service.get(URL, PARAMS);
                break;
            case POST:
                call = service.post(URL, PARAMS);
                break;
            case PUT:
                call = service.put(URL, PARAMS);
                break;
            case DELETE:
                call = service.delete(URL, PARAMS);
                break;
            default:
                break;
        }

        if(call != null) {
            //在另起线程中进行
            call.enqueue(getRequestCallback());
        }
    }

    private Callback<String> getRequestCallback() {
        return new RequestCallbacks(
                IREQUEST,
                ISUCCESS,
                IFAILURE,
                IERROR
        );
    }

    public final void get() {
        request(HttpMethod.GET);
    }

    public final void post() {
        request(HttpMethod.POST);
    }

    public final void put() {
        request(HttpMethod.PUT);
    }

    public final void delete() {
        request(HttpMethod.DELETE);
    }
}
