package com.example.cloudtest.mapper;

import com.example.cloudtest.bean.UserBean;

/**
 * FileName: UserMapper
 * Author:   18311
 * Date:     2021/12/16 0:06
 * Description: mapper接口
 */
public interface UserMapper {
    UserBean getInfo(String name,String password);
}
