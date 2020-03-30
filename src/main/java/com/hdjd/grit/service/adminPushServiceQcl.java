package com.hdjd.grit.service;

import com.google.gson.Gson;
import com.hdjd.grit.mapper.UserMapper;
import com.hdjd.grit.model.pojo.User;
import com.hdjd.grit.model.pojo.VO.AccessToken;
import com.hdjd.grit.model.pojo.VO.TemplateData;
import com.hdjd.grit.model.pojo.VO.WxMssVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName:adminPushServiceQcl
 * @author: yeqi
 * @create: 2020/3/25 10:23
 * @description
 */

@Service
@Slf4j
public class adminPushServiceQcl {
    //用来请求微信的get和post
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserMapper userMapper;

    private final String APPID = "wxf81de870d9761928";
    private final String APPSecret = "5bbf73dea648a692c16354424996e68b";
    /*
     * 后台订单变化通知微信小程序用户
     * */
    public String pushOneUser(String userId,String title,String remarks,String orderNumber) {
        //通过userI查询用户openid
        User user = new User();
        if(userId != null){
            user = userMapper.getUserInfoById(userId);
        }
        String openid = user.getWechatId();
        //获取access_token
        String access_token = getAccess_token(APPID,APPSecret);
        String url = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send" +
                "?access_token=" + access_token;
        System.out.println("access_token===="+access_token);
        //拼接推送的模版
        WxMssVo wxMssVo = new WxMssVo();
        wxMssVo.setTouser(openid);//用户openid
        wxMssVo.setTemplate_id("5OCBsCRy22eqpvuN4M8HOvcyjJIoOqUb-rXwEEfmwO8");//模版id


        Map<String, TemplateData> m = new HashMap<>(5);

        m.put("character_string1",new TemplateData(orderNumber));
        m.put("phrase2",new TemplateData(title));
        m.put("thing5",new TemplateData(remarks));
        wxMssVo.setData(m);

        System.out.println("wxMssVo"+wxMssVo);
        ResponseEntity<String> responseEntity =
                restTemplate.postForEntity(url, wxMssVo, String.class);
        log.error("小程序推送结果={}", responseEntity.getBody());
        return responseEntity.getBody();
    }


    /*
     * 获取access_token
     * appid和appsecret到小程序后台获取，当然也可以让小程序开发人员给你传过来
     * */
    public String getAccess_token(String appid, String appsecret) {
        //获取access_token
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential" +
                "&appid=" + appid + "&secret=" + appsecret;
        String json = restTemplate.getForObject(url, String.class);
        AccessToken accessToken = new Gson().fromJson(json, AccessToken.class);
        return accessToken.getAccess_token();
    }


}
