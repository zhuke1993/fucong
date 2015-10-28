package com.zhuke.Servlet;

import com.zhuke.springjdbc.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ZHUKE on 2015/10/24.
 */
public class ContextParamTest extends HttpServlet{
    @Autowired
    private Person person;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*String t =req.getServletContext().getInitParameter("zhuke");
        System.out.println(t);*/
        System.out.println(person);
    }

}
