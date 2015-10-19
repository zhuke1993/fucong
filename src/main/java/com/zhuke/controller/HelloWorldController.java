package com.zhuke.controller;

import com.zhuke.auth.AuthPassport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/helloworld")
public class HelloWorldController  {

    //@AuthPassport
    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public ModelAndView index() throws RuntimeException{

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "Hello World!");
        modelAndView.setViewName("haha");
        throw new RuntimeException("sunny day");
        //return modelAndView;
    }


    @RequestMapping(value = "/detail/{id}", method = {RequestMethod.GET})
    public ModelAndView getDetail(@PathVariable(value = "id") Integer id) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id", id);
        modelAndView.setViewName("detail");
        return modelAndView;
    }


    @RequestMapping(value = "/teststring")
    public String testString(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {

        modelMap.addAttribute("msg", "nimabi");
        return "stringr";
    }

}
