package com.zhuke.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ZHUKE on 2015/11/9.
 */
@Controller
public class MyController {
    @RequestMapping("/test")
    public String testView() {
        return "myView"; //�����myViewΪlayout.xml�����õ���ͼ����
    }
}
