package com.example.xushiyun.fastec.generators;

/**
 * Created by xushiyun on 2018/3/19.
 * Project Name: FastEc
 * Package Name: com.example.xushiyun.fastec.generators
 * File Name:    AppRegister
 * Description: Todo
 */

import com.example.latte.wechat.template.AppRegisterTemplate;
import com.example.latte_annotations.annotations.AppRegisterGenerator;

@AppRegisterGenerator(
        packageName = "com.example.xushiyun.fastec",
        registerTemplate = AppRegisterTemplate.class)
public interface AppRegister {
}
