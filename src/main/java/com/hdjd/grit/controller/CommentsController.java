package com.hdjd.grit.controller;

import com.hdjd.grit.mapper.CommentsMapper;
import com.hdjd.grit.model.dto.ExtendComments;
import com.hdjd.grit.model.pojo.Comments;
import com.hdjd.grit.model.pojo.UserAndAddress;
import com.hdjd.grit.service.CommentsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName:CommentsController
 * @author: yeqi
 * @create: 2020/3/6 13:29
 * @description
 */
@CrossOrigin
@Api(description = "用户评论")
@RestController
@RequestMapping("comments")
public class CommentsController {
    private final CommentsService commentsService;

    @Autowired
    private CommentsController(CommentsService commentsService){
        this.commentsService = commentsService;
    }

    @PostMapping
    @ApiOperation(value = "新增评论信息", response = Comments.class)
    public ResponseEntity<?> insert(@RequestBody Comments comments) {
        if (comments.getUserId() != null) {
            return commentsService.insert(comments);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    @ApiOperation(value = "查询评论信息", response = ExtendComments.class)
    public List<ExtendComments> getAllComments(){
        return commentsService.getAllComments();
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除评论信息,通过id", response = Comments.class)
    public ResponseEntity<?> deleteById(@RequestParam("id") String id){
        return commentsService.deleteById(id);
    }
}
