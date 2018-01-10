package com.example.latte.ec.launcher;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.example.latte.delegates.LatteDelegate;
import com.example.latte.ec.R;
import com.example.latte.ec.R2;
import com.example.latte.utils.timer.BaseTimerTask;
import com.example.latte.utils.timer.ITimerListener;

import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by xushiyun on 2018/1/10.
 * Project Name: FastEc
 * Package Name: com.example.latte.ec.launcher
 * File Name:    Launcher
 * Descripetion: Todo
 */

public class LauncherDelegate extends LatteDelegate implements ITimerListener{

    @BindView(R2.id.tv_launcher_timer)
    AppCompatTextView mTvTimer = null;

    private Timer mTimer = null;
    private int mCount = 5;

    @OnClick(R2.id.tv_launcher_timer)
    void onClickTimerView() {

    }

    private void initTimer() {
        mTimer = new Timer();
        final BaseTimerTask task = new BaseTimerTask(this);
        mTimer.schedule(task, 0, 1000);
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initTimer();
    }

    @Override
    public void onTimer() {
        getProxyActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(mTvTimer != null) {
                    mTvTimer.setText(MessageFormat.format("跳过\n{0}s", mCount));
                    mCount --;
                    if(mCount < 0) {
                        if(mTimer != null) {
                            mTimer.cancel();
                            mTimer = null;
                        }
                    }
                }
            }
        });
    }
}
