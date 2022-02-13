package com.example.cloudtest.controller;

import com.example.cloudtest.bean.UserBean;
import com.example.cloudtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * FileName: LoginController
 * Author:   18311
 * Date:     2021/12/16 0:46
 * Description: 注入服务
 */
@Controller
public class LoginController {
    //将服务service注入web层

    @Autowired
    UserService userService;
    @RequestMapping("/login")
    public String show(){
        return "login";
    }

    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String login(String name,String password){
        UserBean userBean = userService.loginIn(name,password);
        if(userBean!=null){
            return "success";
        }else{
            return "error";
        }
    }
}
