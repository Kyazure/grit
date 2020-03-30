package com.hdjd.grit.controller;

import com.hdjd.grit.model.pojo.UserAndAddress;
import com.hdjd.grit.service.WxPushServiceQcl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName:WxPushControllerQcl
 * @author: yeqi
 * @create: 2020/3/25 9:11
 * @description
 */
@CrossOrigin
@Api(description = "微信端订阅消息接口")
@RestController
@RequestMapping("wx/message")
public class WxPushControllerQcl {

    @Autowired
    private WxPushServiceQcl wxPushServiceQcl;

    @PostMapping
    @ApiOperation(value = "微信用户下单完成发送订阅信息接口")
    public String wxpushMessage(@RequestParam String userId
            ,@RequestParam String deliveryAddress,@RequestParam String userName
            ,@RequestParam String destination,@RequestParam String time,@RequestParam String telephone) {
        if (userId != null && time != null && deliveryAddress != null&&userName!=null&&destination!=null&&telephone!=null) {
            return wxPushServiceQcl.pushOneUser(userId,deliveryAddress,userName,destination,time,telephone);
        }else {
            return "发送通知失败";
        }
    }


}
