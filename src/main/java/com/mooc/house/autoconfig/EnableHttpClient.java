package com.mooc.house.autoconfig;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)  //注解目标
@Retention(RetentionPolicy.RUNTIME)
@Import(HttpClientAutoConfiguration.class)//引入HttpClientAutoConfiguration这样就可以通过注解实现引用加载该启动依赖
public @interface EnableHttpClient {

}
