package com.zhuke.test;

import com.zhuke.annotation.Constraints;
import com.zhuke.annotation.DBTable;
import com.zhuke.annotation.SQLInteger;
import com.zhuke.annotation.SQLString;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 读取一个类文件，检查其上的数据库注解，用来创建数据库的sql文件
 * Created by ZHUKE on 2015/10/19.
 */
public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {
        if (args.length < 1) {
            System.out.println("arguments: annotated classes");
            System.exit(0);
        }
        for (String className : args) {
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("No DBTable annotations in class" + className);
                continue;
            }
            String tableName = dbTable.name();
            //if the tablename is empty, use the Class name
            if (tableName.length() < 1) {
                tableName = cl.getName().toUpperCase();
            }
            List<String> columnDefs = new ArrayList<>();
            for (Field field : cl.getDeclaredFields()) {
                String columnName = null;
                Annotation[] annotations = field.getDeclaredAnnotations();
                if (annotations.length < 1) {
                    continue;
                }
                if (annotations[0] instanceof SQLInteger) {
                    SQLInteger sInt = (SQLInteger) annotations[0];
                    if (sInt.name().length() < 1) {
                        columnName = field.getName().toLowerCase();
                    } else {
                        columnName = sInt.name();
                    }
                    columnDefs.add(columnName + " INT" + getConstraints(sInt.constraints()));
                }

                if (annotations[0] instanceof SQLString) {
                    SQLString sString = (SQLString) annotations[0];
                    if (sString.name().length() < 1) {
                        columnName = field.getName().toLowerCase();
                    } else {
                        columnName = sString.name();
                    }
                    columnDefs.add(columnName + " VARCHAR(" + sString.value() + ")" + getConstraints(sString.constraints()));
                }

                StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
                for (String colunmDef : columnDefs) {
                    createCommand.append("\n\t" + colunmDef + ",");
                }
                //remove trailing comma
                String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ")";
                System.out.println("table creating for " + className + " is:\n" + tableCreate);
            }
        }
    }


    private static String getConstraints(Constraints con) {
        String constraints = "";
        if (!con.allowNull()) {
            constraints += " NOT NULL";
        }
        if (!con.primaryKey()) {
            constraints += " PRIMARY KEY";
        }
        if (!con.unique()) {
            constraints += " UNIQUE";
        }
        return constraints;
    }
}
