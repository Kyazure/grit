package com.hdjd.grit.controller;

import com.hdjd.grit.model.dto.ExtendComments;
import com.hdjd.grit.model.pojo.Comments;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class CommentsControllerTest {

    @Autowired
    private CommentsController commentsController;

    @Test
    void insert() {
        Comments comments = new Comments();
        comments.setUserId("14bb48e0c09441e9a6da650e2d56c4f9");
        comments.setContent("服务真好！");
        System.out.println(commentsController.insert(comments));
    }

    @Test
    void getAllComments() {
        List<ExtendComments> allComments = commentsController.getAllComments();
        allComments.forEach(extendComments -> System.out.println(extendComments.getCreateTime()));
    }

    @Test
    void deleteById() {
        System.out.println(commentsController.deleteById("1"));
    }

}