package com.hdjd.grit.service;

import com.hdjd.grit.mapper.CommentsMapper;
import com.hdjd.grit.model.dto.ExtendComments;
import com.hdjd.grit.model.pojo.Comments;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName:CommentsService
 * @author: yeqi
 * @create: 2020/3/6 13:24
 * @description
 */

@Service
public class CommentsService {

    @Autowired
    private CommentsMapper commentsMapper;


    public ResponseEntity<?> insert(Comments comments) {
        if (comments != null && comments.getUserId() != null) {
            if (StringUtils.isBlank(comments.getId())) {
                comments.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            }
            if (commentsMapper.insert(comments) > 0) {
                return ResponseEntity.status(HttpStatus.CREATED).build();
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    public List<ExtendComments>getAllComments(){
        return commentsMapper.getAllComments();
    }


    public ResponseEntity<?> deleteById(String id){
        if (id != null) {
            if (commentsMapper.deleteById(id) > 0) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.badRequest().body("id为空，删除失败");
        }
    }
}
