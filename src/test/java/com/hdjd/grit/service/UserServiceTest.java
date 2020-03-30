package com.hdjd.grit.service;

import com.hdjd.grit.model.pojo.RO.WeChatLoginRO;
import com.hdjd.grit.model.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void getWeChatUser() {
    }

    @Test
    void updateUserById() {
        User user = new User();
        user.setId("14bb48e0c09441e9a6da650e2d56c4f9");
        user.setAvatarUrl("image.png");
        user.setName("小明");
        user.setTelephone("1008611");
        System.out.println(userService.updateUserById(user));
    }
}