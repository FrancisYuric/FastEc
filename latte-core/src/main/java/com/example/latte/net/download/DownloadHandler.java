package com.example.latte.net.download;

import android.os.AsyncTask;

import com.example.latte.net.RestCreator;
import com.example.latte.net.callback.IError;
import com.example.latte.net.callback.IFailure;
import com.example.latte.net.callback.IRequest;
import com.example.latte.net.callback.ISuccess;

import java.util.WeakHashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by xushiyun on 2018/1/9.
 * Project Name: FastEc
 * Package Name: com.example.latte.net.download
 * File Name:    DownloadHandler
 * Descripetion: Todo
 */

public class DownloadHandler {

    private final String mUrl;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest mRequest;
    private final String mDownloadDir;
    private final String mExtension;
    private final String mName;
    private final ISuccess mSuccess;
    private final IFailure mFailure;
    private final IError mError;

    public DownloadHandler(String mUrl,
                           IRequest mRequest,
                           String mDownloadDir,
                           String mExtension,
                           String mName,
                           ISuccess mSuccess,
                           IFailure mFailure,
                           IError mError) {
        this.mUrl = mUrl;
        this.mRequest = mRequest;
        this.mDownloadDir = mDownloadDir;
        this.mExtension = mExtension;
        this.mName = mName;
        this.mSuccess = mSuccess;
        this.mFailure = mFailure;
        this.mError = mError;
    }

    public final void handleDownload() {
        if (mRequest != null) {
            mRequest.onRequestStart();
        }
        RestCreator.getRestService().download(mUrl, PARAMS)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.isSuccessful()) {
                            final SaveFileTask task = new SaveFileTask(mRequest, mSuccess);
                            final ResponseBody responseBody = response.body();
                            //调用
                            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, mDownloadDir, mExtension, response, mName);

                            //这里一定要注意判断,否则下载不全
                            if (task.isCancelled()) {
                                if (mRequest != null) {
                                    mRequest.onRequestEnd();
                                }
                            }
                        } else {
                            if(mError != null) {
                                mError.onError(response.code(), response.message());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        if(mFailure!=null) {
                            mFailure.onFailure();
                        }
                    }
                });
    }
}
