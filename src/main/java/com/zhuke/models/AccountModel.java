package com.zhuke.models;

import java.io.Serializable;

/**
 * Created by zhuke on 2015/10/19.
 */
public class AccountModel implements Serializable {
    private String name;
    private String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
