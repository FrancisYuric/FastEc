package com.example.latte.ec.sign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.latte.delegates.LatteDelegate;
import com.example.latte.ec.R;
import com.example.latte.ec.R2;
import com.example.latte.net.RestClient;
import com.example.latte.net.callback.ISuccess;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by xushiyun on 2018/1/11.
 * Project Name: FastEc
 * Package Name: com.example.latte.ec.sign
 * File Name:    SignUpDelegate
 * Descripetion: Todo
 */

public class SignUpDelegate extends LatteDelegate {


    @BindView(R2.id.edit_sign_up_name)
    TextInputEditText editSignUpName = null;
    @BindView(R2.id.edit_sign_up_email)
    TextInputEditText editSignUpEmail = null;
    @BindView(R2.id.edit_sign_up_phone)
    TextInputEditText editSignUpPhone = null;
    @BindView(R2.id.edit_sign_up_password)
    TextInputEditText editSignUpPassword = null;
    @BindView(R2.id.edit_sign_up_re_password)
    TextInputEditText editSignUpRePassword = null;
    @BindView(R2.id.btn_sign_up)
    AppCompatButton btnSignUp = null;
    @BindView(R2.id.tv_link_sign_in)
    AppCompatTextView tvLinkSignIn = null;

    @OnClick(R2.id.btn_sign_up)
    void onClickSignUp() {
        if(checkForm()) {
            //向服务器提交信息
//            RestClient.builder()
//                    .url("sign_up")
//                    .params("", "")
//                    .success(new ISuccess() {
//                        @Override
//                        public void onSuccess(String response) {
//
//                        }
//                    })
//                    .build()
//                    .post();

            Toast.makeText(getContext(), "验证通过", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkForm() {
        final String name = editSignUpName.getText().toString();
        final String email = editSignUpEmail.getText().toString();
        final String phone = editSignUpPhone.getText().toString();
        final String password = editSignUpPassword.getText().toString();
        final String rePassword = editSignUpRePassword.getText().toString();

        boolean isPass = true;

        if(name.isEmpty()) {
            editSignUpName.setError("请输入姓名:");
            isPass = false;
        }
        else {
            editSignUpName.setError(null);
        }

        if(email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editSignUpEmail.setError("错误的邮箱格式");
            isPass = false;
        }
        else {
            editSignUpEmail.setError(null);
        }

        if(phone.isEmpty() || phone.length()!=11) {
            editSignUpPhone.setError("手机号码错误");
            isPass = false;
        }
        else {
            editSignUpPhone.setError(null);
        }

        if(password.isEmpty() || password.length() < 6) {
            editSignUpPassword.setError("请填写至少6位数密码");
            isPass = false;
        }
        else {
            editSignUpPassword.setError(null);
        }

        if(rePassword.isEmpty() || rePassword.length() < 6 || !(rePassword.equals(password))) {
            editSignUpRePassword.setError("密码验证错误");
            isPass = false;
        }
        else {
            editSignUpRePassword.setError(null);
        }
        return isPass;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_up;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }


}
