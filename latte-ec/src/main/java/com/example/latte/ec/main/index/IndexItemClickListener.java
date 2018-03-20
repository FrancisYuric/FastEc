package com.example.latte.ec.main.index;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.example.latte.delegates.LatteDelegate;
import com.example.latte.ec.detail.GoodsDetailDelegate;

/**
 * Created by xushiyun on 2018/3/20.
 * Project Name: FastEc
 * Package Name: com.example.latte.ec.main.index
 * File Name:    IndexItemClickListener
 * Description: Todo
 */

public class IndexItemClickListener extends SimpleClickListener{
    //这里储存的是父视图,因为主页面对应的fragment切换所需的并不是当前的fragment,而是整个页面切换的效果
    private final LatteDelegate DELEGATE;

    private IndexItemClickListener(LatteDelegate delegate) {
        this.DELEGATE = delegate;
    }

    public static IndexItemClickListener create(LatteDelegate delegate) {
        return new IndexItemClickListener(delegate);
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        final GoodsDetailDelegate detailDelegate = GoodsDetailDelegate.create();
        DELEGATE.start(detailDelegate);
    }

    @Override
    public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
