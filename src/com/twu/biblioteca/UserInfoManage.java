package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            System.out.println("login success!");
        } else {
            System.out.println("login failed. please retry.");
        }
    }

    public void loginoutUser(String id) {
        this.loginUserlist = this.loginUserlist.stream().filter((userId) -> !userId.equals(id)).collect(Collectors.toList());
        System.out.println("login out success!");
    }

    public void showUserInfo(String dispalyUserId) {
        boolean isLogin = checkIsLogin(dispalyUserId);
        if (isLogin) {
            this.userlist.stream().filter(user -> user.getId().equals(dispalyUserId)).forEach(user -> {
                System.out.println("user detail information:");
                System.out.println("name: "+user.getName());
                System.out.println("Email: "+user.getEmail());
                System.out.println("Address: "+user.getAddress());
                System.out.println("Phone Number: "+user.getPhoneNumber());
            });
        }else{
            System.out.println("please login");
        }
    }

    public boolean checkIsLogin(String userId) {
        return this.loginUserlist.stream().anyMatch(id -> id.equals(userId));
    }
}
