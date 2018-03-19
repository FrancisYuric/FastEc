package com.example.xushiyun.fastec.generators;

import com.example.latte.wechat.template.WXEntryTemplate;
import com.example.latte_annotations.annotations.EntryGenerator;

/**
 * Created by xushiyun on 2018/3/19.
 * Project Name: FastEc
 * Package Name: com.example.xushiyun.fastec.generators
 * File Name:    WeChatEntry
 * Description: Todo
 */

@EntryGenerator(
        packageName = "com.example.xushiyun.fastec",
        entryTemplete = WXEntryTemplate.class
)
public interface WeChatEntry {
}
