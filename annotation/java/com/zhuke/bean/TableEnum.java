package com.zhuke.bean;

/**
 * Created by ZHUKE on 2015/10/19.
 */
public enum TableEnum {
    STRING("string", "varcher"),

    INTEGER("integer", "int"),

    FLOAT("float", "decimal");

    String name;
    String value;

    TableEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

}
