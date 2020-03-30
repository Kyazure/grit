package com.hdjd.grit.controller;

import com.hdjd.grit.model.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class LoginControllerTest {

    @Autowired
    private LoginController loginController;

    @Test
    void wechatLogin() {
        User user = new User();
        user.setName("yy");
        user.setAvatarUrl("jahhkaj");
//        System.out.println(loginController.wechatLogin("oAkKP4igVjTuFoKgQpVs5xs--ds0",user));
    }

    @Test
    void updateUser() {
    }
}