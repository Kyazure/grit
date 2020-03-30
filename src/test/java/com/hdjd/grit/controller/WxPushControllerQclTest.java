package com.hdjd.grit.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class WxPushControllerQclTest {

    @Autowired
    private WxPushControllerQcl wxPushControllerQcl;

    @Test
    void wxpushMessage() {
//        System.out.println(wxPushControllerQcl.wxpushMessage("oAkKP4iNUXMtZdRvhgaVvhaZjs6I","10:00","100元"));
    }
}