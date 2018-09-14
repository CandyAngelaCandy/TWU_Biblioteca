package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class UserInfoManage {
    private List<User> userlist = new ArrayList<>();

    public List<String> getLoginUserlist() {
        return loginUserlist;
    }

    public void setLoginUserlist(List<String> loginUserlist) {
        this.loginUserlist = loginUserlist;
    }

    private List<String> loginUserlist = new ArrayList<>();

    public List<User> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<User> userlist) {
        this.userlist = userlist;
    }

    public UserInfoManage() {
        initUser();
    }

    public void initUser() {
        List<User> userlist = new ArrayList<>();
        userlist.add(new User("411-2208", "123", "xiao hong", "229355694@qq.com", "Yanta District, Xi'an City, Shaanxi Province", "12345678"));
        userlist.add(new User("411-2209", "123", "xiao liang", "229355694@qq.com", "Yanta District, Xi'an City, Shaanxi Province", "12345678"));
        userlist.add(new User("411-2210", "123", "xiao hei", "229355694@qq.com", "Yanta District, Xi'an City, Shaanxi Province", "12345678"));
        this.userlist = userlist;
    }

    public void loginUser(String id, String password) {
        boolean isExist = this.userlist.stream().anyMatch(user -> user.getId().equals(id) && user.getPassword().equals(password));

        if (isExist) {
            this.loginUserlist.add(id);
        } else {
            System.out.println("library number and password error. please retry.");
        }
    }
}
