package com.example.latte.ec.icon;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

/**
 * Created by xushiyun on 2018/1/7.
 * Project Name: FastEc
 * Package Name: com.example.latte.ec.icon
 * File Name:    FontEcModule
 * Descripetion: Todo
 */

public class FontEcModule implements IconFontDescriptor{
    @Override
    public String ttfFileName() {
        return "iconfont.ttf";
    }

    @Override
    public Icon[] characters() {
        return EcIcons.values();
    }
}
