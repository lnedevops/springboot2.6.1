package com.example.cloudtest.serviceImpl;

import com.example.cloudtest.bean.UserBean;
import com.example.cloudtest.mapper.UserMapper;
import com.example.cloudtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * FileName: UserServiceImpl
 * Author:   18311
 * Date:     2021/12/16 0:25
 * Description: service层业务实现类
 */
@Service
public class UserServiceImpl implements UserService {
    // 将DAO注入Service层
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBean loginIn(String name,String password){
        return userMapper.getInfo(name,password);
    }
}
