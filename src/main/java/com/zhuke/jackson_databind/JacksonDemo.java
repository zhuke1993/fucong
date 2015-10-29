package com.zhuke.jackson_databind;

/**
 * Created by ZHUKE on 2015/10/29.
 */

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonDemo {
    public static void main(String[] args) throws ParseException, IOException {
        User user = new User();
        user.setName("С��");
        user.setEmail("xiaomin@sina.com");
        user.setAge(20);

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(dateformat.parse("1996-10-01"));

        /**
         * ObjectMapper��JSON�����ĺ��ģ�Jackson������JSON����������ObjectMapper��ʵ�֡�
         * ObjectMapper�ж��JSON���л��ķ��������԰�JSON�ַ�������File��OutputStream�Ȳ�ͬ�Ľ����С�
         * writeValue(File arg0, Object arg1)��arg1ת��json���У������浽arg0�ļ��С�
         * writeValue(OutputStream arg0, Object arg1)��arg1ת��json���У������浽arg0������С�
         * writeValueAsBytes(Object arg0)��arg0ת��json���У����ѽ��������ֽ����顣
         * writeValueAsString(Object arg0)��arg0ת��json���У����ѽ��������ַ�����
         */
        ObjectMapper mapper = new ObjectMapper();

        //User��תJSON
        //��������{"name":"С��","age":20,"birthday":844099200000,"email":"xiaomin@sina.com"}
        String json = mapper.writeValueAsString(user);
        System.out.println(json);

        //Java����תJSON
        //��������[{"name":"С��","age":20,"birthday":844099200000,"email":"xiaomin@sina.com"}]
        List<User> users = new ArrayList<User>();
        users.add(user);
        String jsonlist = mapper.writeValueAsString(users);
        System.out.println(jsonlist);
    }
}