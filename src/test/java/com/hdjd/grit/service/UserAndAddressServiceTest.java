package com.hdjd.grit.service;

import com.hdjd.grit.model.pojo.User;
import com.hdjd.grit.model.pojo.UserAndAddress;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserAndAddressServiceTest {

    @Autowired
    private UserAndAddressService userAndAddressService;

    @Test
    void insert() {
        UserAndAddress userAndAddress = new UserAndAddress();
        userAndAddress.setUserId("14bb48e0c09441e9a6da650e2d56c4f9");
        userAndAddress.setAddress("中国");
        System.out.println(userAndAddressService.insert(userAndAddress));
    }
}