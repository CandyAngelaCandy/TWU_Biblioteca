package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UserInfoManageTest {
    UserInfoManage userInfoManage = new UserInfoManage();
    List<User> userlist = new ArrayList<>();
    List<String> loginUserlist = new ArrayList<>();

    final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outputContent));

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

    @Test
    public void should_show_user_information_when_user_login() {
        userInfoManage.loginUser("411-2208", "123");
        userInfoManage.showUserInfo("411-2208");

        assertThat(outputContent.toString(), containsString("name: xiao hong"));
        assertThat(outputContent.toString(), containsString("Email: 229355694@qq.com"));
        assertThat(outputContent.toString(), containsString("Address: Yanta District, Xi'an City, Shaanxi Province"));
        assertThat(outputContent.toString(), containsString("Phone Number: 12345678"));
    }

}