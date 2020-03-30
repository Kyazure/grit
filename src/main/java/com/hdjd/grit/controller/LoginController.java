package com.hdjd.grit.controller;

import com.hdjd.grit.model.pojo.RO.WeChatLoginRO;
import com.hdjd.grit.model.pojo.User;
import com.hdjd.grit.service.UserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/*
 * Created with IntelliJ IDEA.
 *
 * @ClassName:LoginController
 * @author: yeqi
 * @create: 2020/3/5 11:33
 * @description
 */
@CrossOrigin(allowedHeaders="*")
@Api(description = "用户微信登录")
@RestController
@RequestMapping("user/login")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);
    private final String APPID = "wxf81de870d9761928";
    private final String APPSecret = "5bbf73dea648a692c16354424996e68b";
    private final String GRANT_TYPE = "authorization_code";

    private final UserService service;
    private final RestTemplate restTemplate;
    private final HttpSession session;

    private static ConcurrentHashMap<String,HttpSession> httpSession = new ConcurrentHashMap<>();


    @Autowired
    public LoginController(UserService service, RestTemplate restTemplate, HttpSession session) {
        this.service = service;
        this.restTemplate = restTemplate;
        this.session = session;
    }

    /**
     * 微信小程序用户进行登录
     */
    @ApiOperation(value = "微信小程序用户登录")
    @ResponseHeader(name = "auth", description = "验证的token")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功登录"),
            @ApiResponse(code = 201, message = "新用户登录"),
            @ApiResponse(code = 403, message = "用户已注销或被封禁"),
            @ApiResponse(code = 404, message = "微信接口调用出错")
    })
    @RequestMapping(value = "wechat", method = RequestMethod.POST)
    public ResponseEntity<?> wechatLogin(@RequestParam("code") String jsCode,@RequestBody User user, HttpSession session) {
        System.out.println("jsCode==="+jsCode);
        HashMap<String, String> uriVariables = new HashMap<>(4);
        uriVariables.put("appid", APPID);
        uriVariables.put("secret", APPSecret);
        uriVariables.put("js_code", jsCode);
        uriVariables.put("grant_type", GRANT_TYPE);
        WeChatLoginRO responseObject = restTemplate.getForObject(
                "https://api.weixin.qq.com/sns/jscode2session" +
                        "?appid={appid}&secret={secret}&js_code={js_code}&grant_type={grant_type}",
                WeChatLoginRO.class, uriVariables);
        System.out.println("responseObject======"+responseObject);

        if (responseObject != null && responseObject.getOpenId() != null) {
            return service.getWeChatUser(responseObject,user,session);
        }
        return ResponseEntity.notFound().build();
    }



    /**
     * 用户基本信息的更新 通过id更新
     */
    @ApiResponses({
            @ApiResponse(code = 200, message = "更新成功"),
            @ApiResponse(code = 500, message = "服务器错误 重新请求")
    })
    @PostMapping("/update")
    @ApiOperation(value = "更新用户信息,通过用户id", response = User.class)
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        return service.updateUserById(user);
    }
}
