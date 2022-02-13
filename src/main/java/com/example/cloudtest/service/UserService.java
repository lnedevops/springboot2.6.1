package com.example.cloudtest.service;

import com.example.cloudtest.bean.UserBean;

/**
 * FileName: UserService
 * Author:   18311
 * Date:     2021/12/16 0:22
 * Description: 业务接口类
 */
public interface UserService {
    UserBean loginIn(String name,String password);
}
