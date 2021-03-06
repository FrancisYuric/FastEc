package com.example.latte.ec.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.latte.delegates.LatteDelegate;
import com.example.latte.ec.R;

import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * Created by xushiyun on 2018/3/20.
 * Project Name: FastEc
 * Package Name: com.example.latte.ec.detail
 * File Name:    GoodsDetailDelegate
 * Description: Todo
 */

public class GoodsDetailDelegate extends LatteDelegate {
    public static GoodsDetailDelegate create() {
        return new GoodsDetailDelegate();
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_goods_detail;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        //返回水平的切换动画
        return new DefaultHorizontalAnimator();
    }
}
