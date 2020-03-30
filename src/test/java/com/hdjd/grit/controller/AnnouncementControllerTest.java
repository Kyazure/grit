package com.hdjd.grit.controller;

import com.github.pagehelper.PageInfo;
import com.hdjd.grit.model.pojo.Announcement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.Action;

/**
 * @Author: yuan
 * @Date: 2020/3/22 15:48
 * @Version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AnnouncementControllerTest {
    @Autowired
    AnnouncementController announcementController;
    @Test
    public void getAll(){
        PageInfo<Announcement> goodsForPage = announcementController.getGoodsForPage(null, null);
        goodsForPage.getList().forEach(announcement -> {
            System.out.println(announcement.getCreateTime().toLocaleString());
        });
    }
}
