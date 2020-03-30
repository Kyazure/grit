package com.hdjd.grit.controller;

import com.hdjd.grit.model.pojo.UserAndAddress;
import com.hdjd.grit.service.UserAndAddressService;
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
 * @ClassName:UserAndAddressController
 * @author: yeqi
 * @create: 2020/3/5 18:11
 * @description
 */
@CrossOrigin
@Api(description = "用户和地址")
@RestController
@RequestMapping("user/address")
public class UserAndAddressController {
    @Autowired
    private UserAndAddressService userAndAddressService;

    @PostMapping
    @ApiOperation(value = "新增地址信息", response = UserAndAddress.class)
    public ResponseEntity<?> insert(@RequestBody UserAndAddress userAndAddress) {
        if (userAndAddress.getUserId() != null) {
            return userAndAddressService.insert(userAndAddress);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }


    @DeleteMapping("/deleteById")
    @ApiOperation(value = "删除信息 ,通过id")
    public ResponseEntity<?> deleteById(@RequestParam String id) {
        return userAndAddressService.deleteById(id);
    }

    @PutMapping("/updateById")
    @ApiOperation(value = "更新信息 ,通过id")
    public  ResponseEntity<?> updateById(@RequestBody UserAndAddress userAndAddress){
        if (userAndAddress.getId()!=null&&userAndAddress.getUserId()!=null){
            return userAndAddressService.updateById(userAndAddress);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/queryById")
    @ApiOperation(value = "查询用户的地址信息 ,通过userId")
    public List<UserAndAddress> getUserAddress(@RequestParam String userId){
        if (userId!=null){
            return userAndAddressService.getUserAddress(userId);
        }
        return null;
    }
}
