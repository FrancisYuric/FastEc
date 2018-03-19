package com.example.latte.app;

import com.example.latte.utils.storage.LattePreference;

/**
 * Created by xushiyun on 2018/3/19.
 * Project Name: FastEc
 * Package Name: com.example.latte.app
 * File Name:    AccountManager
 * Description: Todo
 */

public class AccountManager {

    private enum SignTag {
        SIGN_TAG
    }

    //保存用户登录状态,登录后调用
    public static void setSignState(boolean state) {
        LattePreference.setAppFlag(SignTag.SIGN_TAG.name(), state);
    }

    private  static boolean isSignIn() {
        return LattePreference.getAppFlag(SignTag.SIGN_TAG.name());
    }

    public static void checkAccount(IUserChecker checker) {
        if(isSignIn()) {
            checker.onNotSignIn();
        }
        else {
            checker.onNotSignIn();
        }
    }
}
