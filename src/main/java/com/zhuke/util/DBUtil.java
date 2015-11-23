package com.zhuke.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by ZHUKE on 2015/11/9.
 */
public class DBUtil {
    public static Connection getConnetction() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/my_aiaf", "root", "92984318");
    }
}
