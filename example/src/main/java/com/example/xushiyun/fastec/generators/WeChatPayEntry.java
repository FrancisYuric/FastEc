package com.example.xushiyun.fastec.generators;

import com.example.latte.wechat.template.WXPayEntryTemplate;
import com.example.latte_annotations.annotations.PayEntryGenerator;

/**
 * Created by xushiyun on 2018/3/19.
 * Project Name: FastEc
 * Package Name: com.example.xushiyun.fastec.generators
 * File Name:    WeChatPayEntry
 * Description: Todo
 */
@PayEntryGenerator(packageName = "com.example.xushiyun.fastec",
        entryTemplete = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
