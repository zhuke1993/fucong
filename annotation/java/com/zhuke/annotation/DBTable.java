package com.zhuke.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ZHUKE on 2015/10/19.
 */
@Target(ElementType.TYPE)//该注解只用应用于/** Class, interface (including annotation type), or enum declaration */
@Retention(RetentionPolicy.RUNTIME)
/**
 * 对象关系映射，自定义
 */
public @interface DBTable {
    //用于创建数据库表的时候提供表的名字
    public String name() default "";
}
