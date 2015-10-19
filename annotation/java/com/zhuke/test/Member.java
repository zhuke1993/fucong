package com.zhuke.test;

import com.zhuke.annotation.*;
import com.zhuke.bean.TableEnum;

/**
 * Created by ZHUKE on 2015/10/19.
 */
@DBTable(name = "MEMBER")
public class Member {
    @SQLString(value = 30)
    String firstName;

    @SQLString(50)
    String lastName;

    @SQLInteger
    int age;

    @SQLString(value = 30, constraints = @Constraints(primaryKey = true))
    String handle;

    @TableColumn(TABLE_ENUM = TableEnum.FLOAT)
    String table_enum;

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
