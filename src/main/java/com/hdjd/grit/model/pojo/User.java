package com.hdjd.grit.model.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@ApiModel(value = "User", description = "用户模型")
@TableName("user")
public class User implements Serializable {
    /**
     * id
     * 
     */
    @TableId
    @ApiModelProperty("用户主键")
    private String id;

    /**
     * name
     * 用户微信名
     */
    @ApiModelProperty("用户微信名")
    private String name;

    /**
<<<<<<< HEAD
     * name
     * 用户微信id
     */
    @ApiModelProperty(value = "农户微信", name = "wechat_id")
    private String wechatId;

    /**
=======
>>>>>>> 05d7c36a2f432c63cbf5ef97c6da7c8174147011
     * telephone
     * 用户电话
     */
    @ApiModelProperty("用户电话")
    private String telephone;

    /**
     * fettle
     * 用户账号状态,0表示正常，1表示封禁
     */
    @ApiModelProperty("用户账号状态,0表示正常，1表示封禁")
    private Byte fettle;

    /**
     * avatar_url
     * 用户头像
     */
    @ApiModelProperty("用户头像路径")
    private String avatarUrl;

    /**
     * create_time
     * 用户创建时间
     */
    @ApiModelProperty("用户创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
    private Date createTime;

    /**
     * update_time
     * 
     */
    @ApiModelProperty("修改用户时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
    private Date updateTime;

}