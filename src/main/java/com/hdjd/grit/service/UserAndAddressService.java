package com.hdjd.grit.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.hdjd.grit.mapper.UserAndAddressMapper;
import com.hdjd.grit.mapper.UserMapper;
import com.hdjd.grit.model.pojo.UserAndAddress;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.

 * @ClassName:UserAndAddressService
 * @author: yeqi
 * @create: 2020/3/5 17:03
 * @description
 */

@Service
public class UserAndAddressService {

    private final UserAndAddressMapper userAndAddressMapper;
    private final UserMapper userMapper;

    @Autowired
    public UserAndAddressService(UserAndAddressMapper userAndAddressMapper, UserMapper userMapper) {
        this.userAndAddressMapper = userAndAddressMapper;
        this.userMapper = userMapper;
    }


    public ResponseEntity<?> insert(UserAndAddress userAndAddress) {
        if (userAndAddress != null && userMapper.getUserInfoById(userAndAddress.getUserId()) != null) {
            if (StringUtils.isBlank(userAndAddress.getId())) {
                userAndAddress.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            }
            if (userAndAddressMapper.insert(userAndAddress) > 0) {
                return ResponseEntity.status(HttpStatus.CREATED).build();
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            return ResponseEntity.badRequest().body("输入信息为空");
        }
    }

    public ResponseEntity<?> deleteById(String id) {
        if (id != null) {
            if (userAndAddressMapper.deleteById(id) > 0) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.badRequest().body("id为空，删除失败");
        }
    }

    public ResponseEntity<?> updateById(UserAndAddress userAndAddress) {
        if (userAndAddress.getId() != null && userAndAddress.getUserId() != null) {
            if (userAndAddressMapper.updateById(userAndAddress) > 0) {
                return ResponseEntity.status(HttpStatus.CREATED).build();
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            return ResponseEntity.badRequest().body("当前无更新的对象");
        }
    }

    public List<UserAndAddress> getUserAddress(String userId) {
        if (!userId.isEmpty()) {
            List<UserAndAddress> userAndAddressList = userAndAddressMapper.getUserAddress(userId);
            return userAndAddressList;
        }
        return null;
    }
}