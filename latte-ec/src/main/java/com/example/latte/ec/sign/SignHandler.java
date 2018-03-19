package com.example.latte.ec.sign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.latte.app.AccountManager;
import com.example.latte.ec.database.DatabaseManager;
import com.example.latte.ec.database.UserProfile;


/**
 * Created by xushiyun on 2018/1/19.
 * Project Name: FastEc
 * Package Name: com.example.latte.ec.sign
 * File Name:    SignHandler
 * Descripetion: Todo
 */

public class SignHandler {
    public static void onSignIn(String response, ISignListener mISignListener) {
        final JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");

//        final long userId = profileJson.getLong("userId");
        final String name = profileJson.getString("name");
        final String avatar = profileJson.getString("avatar");
        final String gender = profileJson.getString("gender");
        final String address = profileJson.getString("address");
        final long userId = System.currentTimeMillis();

        final UserProfile profile = new UserProfile(userId, name, avatar, gender, address);
        DatabaseManager.getInstance().getDao().insertOrReplace(profile);

        //保存用户状态
        //已经注册并登录成功了
        AccountManager.setSignState(true);
        mISignListener.onSignInSuccess();
    }


    public static void onSignUp(String response, ISignListener mISignListener) {
        final JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");

//        final long userId = profileJson.getLong("userId");
        final String name = profileJson.getString("name");
        final String avatar = profileJson.getString("avatar");
        final String gender = profileJson.getString("gender");
        final String address = profileJson.getString("address");
        final long userId = System.currentTimeMillis();

        final UserProfile profile = new UserProfile(userId, name, avatar, gender, address);
        DatabaseManager.getInstance().getDao().insertOrReplace(profile);

        //保存用户状态
        //已经注册并登录成功了
        AccountManager.setSignState(true);
        mISignListener.onSignUpSuccess();
    }
}
