package com.zhuke.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhuke on 2015/10/19.
 */
@Controller
@RequestMapping(value = "/account")
public class AccountController {

    @RequestMapping(value = "login", method = {RequestMethod.GET})
    public String login() {
        return "login";

    }
}
