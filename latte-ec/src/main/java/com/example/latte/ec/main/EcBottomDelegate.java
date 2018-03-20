package com.example.latte.ec.main;

import android.graphics.Color;

import com.example.latte.delegates.buttom.BaseBottomDelegate;
import com.example.latte.delegates.buttom.BottomItemDelegate;
import com.example.latte.delegates.buttom.BottomTabBean;
import com.example.latte.delegates.buttom.ItemBuilder;
import com.example.latte.ec.main.index.IndexDelegate;

import java.util.LinkedHashMap;

/**
 * Created by xushiyun on 2018/3/20.
 * Project Name: FastEc
 * Package Name: com.example.latte.ec.main.index
 * File Name:    EcBottomDelegate
 * Description: Todo
 */

public class EcBottomDelegate extends BaseBottomDelegate {
    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder itemBuilder) {
        final LinkedHashMap<BottomTabBean, BottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}", "主页"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-sort}", "分类"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-compass}", "发现"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-shopping-cart}", "购物车"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-user}", "我的"), new IndexDelegate());

        return itemBuilder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}
