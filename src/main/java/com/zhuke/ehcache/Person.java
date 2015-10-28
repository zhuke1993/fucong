package com.zhuke.ehcache;

import java.io.Serializable;

/**
 * Created by zhuke on 2015/10/23.
 */
public class Person implements Serializable {
    private String name;
    private String description;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Person(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
