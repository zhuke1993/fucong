package com.zhuke.beanutil;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by ZHUKE on 2015/11/9.
 */
public class BeanUtilTest {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        //复制bean
        Person p = new Person();
        p.setName("朱轲");
        p.setAge(22);
        Teacher t = new Teacher();
        t.setName("张法文");
        t.setAge(44);
        t.setPerson(p);
        System.out.println(t);
        System.out.println("----------------");
        Teacher t1 = (Teacher) BeanUtils.cloneBean(t);
        t1.getPerson().setName("呀么得");
        System.out.println("t----->"+t);
        System.out.println("t1----->"+t1);


    }
}
