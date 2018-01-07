package com.example.latte.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by xushiyun on 2018/1/7.
 * Project Name: FastEc
 * Package Name: com.example.latte.ec.icon
 * File Name:    EcIcons
 * Descripetion: Todo
 */

public enum EcIcons implements Icon {
    icon_alipay('\ue63d'),
    icon_scan('\ue60c');

    private char character;

    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
