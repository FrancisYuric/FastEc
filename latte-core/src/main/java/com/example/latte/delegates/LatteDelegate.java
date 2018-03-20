package com.example.latte.delegates;

/**
 * Created by xushiyun on 2018/1/8.
 * Project Name: FastEc
 * Package Name: com.example.latte.delegates
 * File Name:    LatteDelegate
 * Descripetion: Todo
 */

public abstract class LatteDelegate extends PermissionCheckerDelegate {
    @SuppressWarnings("unchecked")
    public <T extends LatteDelegate> T getParentDelegate() {
        return (T) getParentFragment();
    }
}
