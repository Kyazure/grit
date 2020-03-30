package com.hdjd.grit.model.pojo.RO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/*
 * \* Created with IntelliJ IDEA.
 * \* @author: yeqi
 * \* Date: 2019-03-5
 * \* Time: 上午9:43
 * \* Description:微信登录接口响应的对象
 * \
 */
@Data
public class WeChatLoginRO {
    @JsonProperty("openid")
    private String openId;
    @JsonProperty("session_key")
    private String sessionKey;
    @JsonProperty("unionid")
    private String unionId;
    @JsonProperty("errcode")
    private Integer errCode;
    @JsonProperty("errmsg")
    private String errMsg;
}
