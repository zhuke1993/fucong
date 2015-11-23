package com.zhuke.jasperreports;

import com.zhuke.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by ZHUKE on 2015/11/9.
 */
public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = DBUtil.getConnetction();

    }
}
