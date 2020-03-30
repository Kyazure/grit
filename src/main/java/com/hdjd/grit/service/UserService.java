package com.hdjd.grit.service;

import com.hdjd.grit.mapper.UserMapper;
import com.hdjd.grit.model.pojo.RO.WeChatLoginRO;
import com.hdjd.grit.model.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.

 * @ClassName:UserService
 * @author: yeqi
 * @create: 2020/3/5 10:56
 * @description
 */

@Service
public class UserService {
    private final UserMapper userMapper;


    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public ResponseEntity<?> getWeChatUser(WeChatLoginRO weChatLoginRO,User user,HttpSession session) {
        String openId = weChatLoginRO.getOpenId();
        String id = userMapper.getUserIdByWeChatId(openId);
        // token message
        HttpHeaders httpHeaders = new HttpHeaders();
        if (id == null) {
//            User user = new User();
            user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            user.setWechatId(openId);

            if (userMapper.insertWeChatUserIds(user) > 0) {
                session.setAttribute("user", user);
                return new ResponseEntity<>(user, httpHeaders, HttpStatus.CREATED);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
//            User user = new User();
            user.setId(id);
            session.setAttribute("user", user);
            return new ResponseEntity<>(userMapper.getUserInfoById(id), httpHeaders, HttpStatus.OK);
        }
    }
//public ResponseEntity<?> getWeChatUser(String openId, User user, String sessionId) {
////   String openId = weChatLoginResponseObject.getOpenId();
//    String id = userMapper.getUserIdByWeChatId(openId);
//    // token message
//    HttpHeaders httpHeaders = new HttpHeaders();
//
//    if (id == null) {
//        String uuId = UUID.randomUUID().toString().replaceAll("-", "");
//        user.setId(uuId);
//        user.setWechatId(openId);
//        if (user.getTelephone() == null)
//            user.setTelephone("null");
//        if(user.getAvatarUrl() == null){
//            user.setAvatarUrl("/images/user/default.jpg");
//            user.setAvatarUrl(System.getProperty("user.dir") + "/images/user/default.jpg");
//        }
//        if(user.getName() == null)
//            user.setName("未命名");
//        //todo 添加年龄
//
//
//        if (userMapper.insertWeChatUserIds(user) > 0) {
//            String searchId = userMapper.getUserIdByWeChatId(openId);
//            httpHeaders.setBearerAuth(JwtUtil.generateTokenById(openId,searchId));
//            httpHeaders.set("sessionId",sessionId);
//            return new ResponseEntity<>(user, httpHeaders, HttpStatus.CREATED);
//        } else {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    } else {
//
//        User userInfo = userMapper.getUserInfoById(id);
//        if (userInfo != null) {
//            httpHeaders.setBearerAuth(JwtUtil.generateTokenById(openId,id));
//            return new ResponseEntity<>(userInfo, httpHeaders, HttpStatus.OK);
//        } else {
//            // 用户已注销或封禁
//            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
//        }
//    }
//}



    public ResponseEntity<?> updateUserById(User user) {
        if (userMapper.updateUserById(user) == 1) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
