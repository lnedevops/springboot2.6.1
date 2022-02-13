package com.example.cloudtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * FileName: HelloController
 * Author:   18311
 * Date:     2021/12/15 23:10
 * Description: controller测试类
 */
@Controller
public class HelloController {
    @RequestMapping("/index")
    public String sayHello(){
        return "index";
    }
}
