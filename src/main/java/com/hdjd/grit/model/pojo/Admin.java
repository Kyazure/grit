package com.hdjd.grit.model.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@ApiModel(value = "Admin", description = "管理员模型")
@TableName("admin")
public class Admin implements Serializable {
    /**
     * id
     * 
     */
    @TableId
    @ApiModelProperty("管理员主键")
    private String id;

    /**
     * name
     * 管理员用户名
     */
    @ApiModelProperty("管理员用户名")
    private String name;

    /**
     * password
     * 管理员密码
     */
    @ApiModelProperty("管理员密码")
    private String password;

    /**
     * telephone
     * 管理员电话
     */
    @ApiModelProperty("管理员电话")
    private String telephone;

    /**
     * super_key
     * 超级管理员标识 (0,普通管理员  1,超级管理员)
     */
    @ApiModelProperty("超级管理员标识 (0,普通管理员  1,超级管理员)")
    private Byte superKey;

    /**
     * is_delete
     * 是否删除,0表示未删除,1表示已经删除
     */
    @ApiModelProperty("是否删除,0表示未删除,1表示已经删除")
    private Byte isDelete;

    /**
     * create_time
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
    private Date createTime;

    /**
     * update_time
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
    private Date updateTime;

}