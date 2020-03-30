package com.hdjd.grit.model.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@ApiModel(value = "UserAndAddress", description = "用户地址模型")
@TableName("user_address")
public class UserAndAddress implements Serializable {
    /**
     * id
     * 
     */
    @TableId
    @ApiModelProperty("用户地址主键")
    private String id;

    /**
     * user_id
     * 用户id
     */
    @ApiModelProperty("用户id")
    private String userId;

    /**
     * address
     * 详细地址
     */
    @ApiModelProperty("详细地址")
    private String address;

    /**
     * contact_name
     * 联系人姓名
     */
    @ApiModelProperty("联系人姓名")
    private String contactName;

    /**
     * contact_phone
     * 联系人电话
     */
    @ApiModelProperty("联系人电话")
    private String contactPhone;

    /**
     * building_nature
     * 楼房性质
     */
    @ApiModelProperty("楼房性质:'电梯房','楼梯房'")
    private String buildingNature;

    /**
     * property_nature
     * 楼盘性质
     */
    @ApiModelProperty("楼盘性质:'小区','写字楼','民宅'")
    private String propertyNature;

    /**
     * longitude
     * 经度
     */
    @ApiModelProperty("经度")
    private String longitude;

    /**
     * latitude
     * 纬度
     */
    @ApiModelProperty("纬度")
    private String latitude;

}