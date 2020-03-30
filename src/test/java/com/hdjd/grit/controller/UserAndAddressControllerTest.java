package com.hdjd.grit.controller;

import com.hdjd.grit.model.pojo.User;
import com.hdjd.grit.model.pojo.UserAndAddress;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserAndAddressControllerTest {

    @Autowired
    private UserAndAddressController userAndAddressController;

//    @Test
////    void insert() {
////        UserAndAddress userAndAddress = new UserAndAddress();
////        userAndAddress.setUserId("14bb48e0c09441e9a6da650e2d56c4f9");
////        System.out.println(userAndAddressController.insert(userAndAddress));
////    }

    @Test
    void deleteById() {
        System.out.println(userAndAddressController.deleteById("1f48223294eb4c8c8c70f5ae19464c2a"));
    }

    @Test
    void updateById() {
//        UserAndAddress userAndAddress = new UserAndAddress();
//        userAndAddress.setId("c027e90c22ab4a68b8784db654d4c7c7");
//        userAndAddress.setAddress("中国");
//        userAndAddress.setUserId("d7ecf7faae4a4f0b868a480b8095f07b");
//        System.out.println(userAndAddressController.updateById(userAndAddress));
    }

    @Test
    void getUserAddress() {
        System.out.println(userAndAddressController.getUserAddress("d7ecf7faae4a4f0b868a480b8095f07b"));
    }

}