package com.example.cloudtest.bean;

/**
 * FileName: UserBean
 * Author:   18311
 * Date:     2021/12/16 0:01
 * Description: bean实体类
 */
public class UserBean {
    private int id;
    private String name;
    private String password;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
