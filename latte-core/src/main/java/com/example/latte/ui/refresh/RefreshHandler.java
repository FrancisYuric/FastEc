package com.example.latte.ui.refresh;

import android.support.v4.widget.SwipeRefreshLayout;

import com.example.latte.app.Latte;

/**
 * Created by xushiyun on 2018/3/20.
 * Project Name: FastEc
 * Package Name: com.example.latte.ui.refresh
 * File Name:    RefreshHandler
 * Description: Todo
 */

public class RefreshHandler implements SwipeRefreshLayout.OnRefreshListener {
    private final SwipeRefreshLayout REFRESH_LAYOUT;

    public RefreshHandler(SwipeRefreshLayout REFRESH_LAYOUT) {
        this.REFRESH_LAYOUT = REFRESH_LAYOUT;
        REFRESH_LAYOUT.setOnRefreshListener(this);
    }

    private void refresh() {
        REFRESH_LAYOUT.setRefreshing(true);
        Latte.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //进行一些网络请求,届时将停止刷新方法设置到返回请求回调中
                REFRESH_LAYOUT.setRefreshing(false);
            }
        }, 2000);
    }

    @Override
    public void onRefresh() {
        refresh();
    }
}
