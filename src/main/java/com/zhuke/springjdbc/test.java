package com.zhuke.springjdbc;

import com.zhuke.springjdbc.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ZHUKE on 2015/10/26.
 */
public class test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext();
        Person person = (Person) context.getBean("person");
        System.out.println(person.getName() + person.getAge());
    }
}
