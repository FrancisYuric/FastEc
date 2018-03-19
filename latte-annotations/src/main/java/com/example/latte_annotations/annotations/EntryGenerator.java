package com.example.latte_annotations.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by xushiyun on 2018/3/19.
 * Project Name: FastEc
 * Package Name: com.example.latte_annotations.annotations
 * File Name:    Entry
 * Description: Todo
 */


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface EntryGenerator {
    String packageName();

    Class<?> entryTemplete();
}
