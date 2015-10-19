package com.zhuke.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ZHUKE on 2015/10/19.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SimulatingNull {
    //由于编译器对元素的默认值有些过分挑剔
    //1.元素不能有不确定的值
    //2.元素必须要么具有默认值，要么在使用注解时提供元素的值
    public int id() default -1;

    public String description() default "";

}
