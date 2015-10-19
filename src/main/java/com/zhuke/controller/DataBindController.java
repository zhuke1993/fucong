package com.zhuke.controller;

import com.zhuke.models.AccountModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhuke on 2015/10/19.
 */
@Controller
@RequestMapping("/databind")
public class DataBindController {

    @RequestMapping(value = "/parambind", method = {RequestMethod.GET})
    public ModelAndView paramBind() {

        ModelAndView model = new ModelAndView();
        model.setViewName("parambind");
        return model;
    }

    @RequestMapping(value = "/parambind", method = {RequestMethod.POST})
    public ModelAndView paramBind(HttpServletRequest request,
                                  @RequestParam("urlParam") String urlParam,
                                  @RequestParam("formParam") String formParam,
                                  @RequestParam("formFile") MultipartFile formFile) {

        //如果不用注解自动绑定，我们还可以像下面一样手动获取数据
        String urlParam1 = ServletRequestUtils.getStringParameter(request, "urlParam", null);
        String formParam1 = ServletRequestUtils.getStringParameter(request, "formParam", null);
        MultipartFile formFile1 = ((MultipartHttpServletRequest) request).getFile("formFile");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("urlParam", urlParam);
        modelAndView.addObject("formParam", formParam);
        modelAndView.addObject("formFileName", formFile.getOriginalFilename());

        modelAndView.addObject("urlParam1", urlParam1);
        modelAndView.addObject("formParam1", formParam1);
        modelAndView.addObject("formFileName1", formFile1.getOriginalFilename());
        modelAndView.setViewName("parambindresult");
        return modelAndView;
    }


   /* @RequestMapping(value = "/modelautobind", method = {RequestMethod.GET})
    public String modelAutoBind(HttpServletRequest request, Model model) {

        model.addAttribute("accountmodel", new AccountModel());
        return "modelautobind";
    }*/

    /*@RequestMapping(value = "/modelautobind", method = {RequestMethod.POST})
    public String modelAutoBind(HttpServletRequest request, Model model, AccountModel accountModel) {

        model.addAttribute("accountmodel", accountModel);
        return "modelautobindresult";
    }*/

    @RequestMapping(value = "/cookiebind", method = {RequestMethod.POST, RequestMethod.GET})
    public String coockieBind(HttpServletRequest request, Model model,
                              @CookieValue(value = "JSESSIONID", defaultValue = "") String jsessionId) {
        model.addAttribute("jsessionId", jsessionId);
        return "cookiebindresult";
    }

    @RequestMapping(value = "/requestheaderbind", method = {RequestMethod.GET})
    public String requestHeaderBind(HttpServletRequest request, Model model,
                                    @RequestHeader(value = "User-Agent", defaultValue = "") String userAgent) {

        model.addAttribute("userAgent", userAgent);
        return "requestheaderbindresult";
    }


    @RequestMapping(value = "/modelautobind", method = {RequestMethod.POST})
    public String modelAutoBind(HttpServletRequest request,
                                @ModelAttribute("accountmodel") AccountModel accountModel) {
        return "modelautobindresult";
    }


    @ModelAttribute("sessionaccountmodel")
    public AccountModel initAccountModel() {

        return new AccountModel();
    }

    @RequestMapping(value = "/usernamebind", method = {RequestMethod.GET})
    public String userNameBind(Model model, AccountModel accountModel) {

        model.addAttribute("sessionaccountmodel", new AccountModel());
        return "usernamebind";
    }

    @RequestMapping(value = "/usernamebind", method = {RequestMethod.POST})
    public String userNameBindPost(@ModelAttribute("sessionaccountmodel") AccountModel accountModel) {

        //重定向到密码绑定测试
        return "redirect:passwordbind";
    }

    @RequestMapping(value = "/passwordbind", method = {RequestMethod.GET})
    public String passwordBind(@ModelAttribute("sessionaccountmodel") AccountModel accountModel) {

        return "passwordbind";
    }

    @RequestMapping(value = "/passwordbind", method = {RequestMethod.POST})
    public String passwordBindPost(@ModelAttribute("sessionaccountmodel") AccountModel accountModel, SessionStatus status) {

        //销毁@SessionAttributes存储的对象
        status.setComplete();
        //显示绑定结果
        return "sessionmodelbindresult";
    }


    @RequestMapping(value = "/requestbodybind", method = {RequestMethod.GET})
    public String requestBodyBind(Model model) {
        model.addAttribute("accountmodel", new AccountModel());
        return "requestbodybind";
    }

    @RequestMapping(value = "/requestbodybind", method = {RequestMethod.POST})
    public
    @ResponseBody
    AccountModel requestBodyBind(@RequestBody AccountModel accountModel) {

        return accountModel;
    }
}
