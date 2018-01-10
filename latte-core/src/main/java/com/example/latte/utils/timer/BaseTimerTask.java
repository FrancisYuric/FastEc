package com.example.latte.utils.timer;

import java.util.TimerTask;

/**
 * Created by xushiyun on 2018/1/10.
 * Project Name: FastEc
 * Package Name: com.example.latte.utils.timer
 * File Name:    BaseTimerTask
 * Descripetion: Todo
 */

public class BaseTimerTask extends TimerTask {
    private ITimerListener mITimerListener = null;

    public BaseTimerTask(ITimerListener mITimerListener) {
        this.mITimerListener = mITimerListener;
    }

    @Override
    public void run() {
        if(mITimerListener !=null) {
            mITimerListener.onTimer();
        }
    }
}
