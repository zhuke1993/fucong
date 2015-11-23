package com.zhuke.jackson_databind;

/**
 * Created by ZHUKE on 2015/10/29.
 */

import java.io.IOException;
import java.text.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonDemo1 {
    public static void main(String[] args) throws ParseException, IOException {
        String json = "{\"name\":\"С��\",\"age\":20,\"birthday\":844099200000,\"email\":\"xiaomin@sina.com\"}";

        /**
         * ObjectMapper֧�ִ�byte[]��File��InputStream���ַ��������ݵ�JSON�����л���
         */
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(json, User.class);
        System.out.println(user.getName());
    }
}
