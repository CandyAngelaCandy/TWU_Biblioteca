package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UserInfoManageTest {
    UserInfoManage userInfoManage = new UserInfoManage();
    List<User> userlist = new ArrayList<>();
    List<String> loginUserlist = new ArrayList<>();

    @Before
    public void setup() {
        userlist.add(new User("411-2208", "123", "xiao hong", "229355694@qq.com", "Yanta District, Xi'an City, Shaanxi Province", "12345678"));
        userlist.add(new User("411-2209", "123", "xiao liang", "229355694@qq.com", "Yanta District, Xi'an City, Shaanxi Province", "12345678"));
        userlist.add(new User("411-2210", "123", "xiao hei", "229355694@qq.com", "Yanta District, Xi'an City, Shaanxi Province", "12345678"));

    }

    @Test
    public void should_user_login_when_input_correct_id_password() {
        userInfoManage.loginUser("411-2208", "123");
        loginUserlist.add("411-2208");
        assertThat(userInfoManage.getLoginUserlist(), is(loginUserlist));
    }

    @Test
    public void should_user_login_out_when_input_correct_id_password() {
        userInfoManage.loginUser("411-2209", "123");
        loginUserlist.add("411-2209");
        userInfoManage.loginoutUser("411-220");
        loginUserlist.remove("411-220");
        assertThat(userInfoManage.getLoginUserlist(), is(loginUserlist));

    }

}