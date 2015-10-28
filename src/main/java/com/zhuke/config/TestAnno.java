package com.zhuke.config;

import com.zhuke.springjdbc.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ZHUKE on 2015/10/27.
 */
public class TestAnno {
    @Autowired
    private static Person person;

    public static void main(String[] args) {

        System.out.println(person.getName() + "--" + person.getName());
    }
}
