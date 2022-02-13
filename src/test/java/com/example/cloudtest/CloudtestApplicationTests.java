package com.example.cloudtest;

import com.example.cloudtest.bean.UserBean;
import com.example.cloudtest.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CloudtestApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        UserBean userBean = userService.loginIn("fengsulin","123456");
        System.out.println("该用户的ID为：");
        System.out.println(userBean.getId());
    }

}
