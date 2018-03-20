package com.example.latte.ec.main.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.latte.delegates.buttom.BottomItemDelegate;
import com.example.latte.ec.R;
import com.example.latte.ec.R2;
import com.example.latte.ui.refresh.RefreshHandler;
import com.joanzapata.iconify.widget.IconTextView;

import butterknife.BindView;

/**
 * Created by xushiyun on 2018/3/20.
 * Project Name: FastEc
 * Package Name: com.example.latte.ec.main.index
 * File Name:    IndexDelegate
 * Description: Todo
 */

public class IndexDelegate extends BottomItemDelegate {

    @BindView(R2.id.rv_index)
    RecyclerView mRecyclerView = null;
    @BindView(R2.id.srl_index)
    SwipeRefreshLayout mRefreshLayout = null;
    @BindView(R2.id.icon_index_scan)
    IconTextView mIconScan = null;
    @BindView(R2.id.et_search_view)
    AppCompatEditText mSearchView = null;
    @BindView(R2.id.tb_index)
    Toolbar mToolbar = null;

    private RefreshHandler mRefreshHandler = null;
    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mRefreshHandler = new RefreshHandler(mRefreshLayout);
    }

    private void initRefreshLayout() {
        //设置下拉刷新的状态条,在加载时显示的颜色变化
        mRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        mRefreshLayout.setProgressViewOffset(true, 120, 300);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initRefreshLayout();
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }

}
