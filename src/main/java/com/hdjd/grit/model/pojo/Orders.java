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
@ApiModel(value = "Orders", description = "订单模型")
@TableName("orders")
public class Orders implements Serializable{
    /**
     * id
     * 
     */
    @TableId
    @ApiModelProperty("订单主键")
    private String id;

    /**
     * user_id
     * 用户id
     */
    @ApiModelProperty("用户id")
    private String userId;

    /**
     * delivery_time
     * 配送时间
     */
    @ApiModelProperty("配送时间")
    private String deliveryTime;

    /**
     * delivery_address
     * 配送地址
     */
    @ApiModelProperty("配送地址")
    private String deliveryAddress;

    /**
     * contact_name
     * 联系人姓名
     */
    @ApiModelProperty("联系人姓名")
    private String contactName;

    /**
     * contact_phone
     * 联系人电话或者座机号码
     */
    @ApiModelProperty("联系方式")
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
     * remark
     * 说明
     */
    @ApiModelProperty("订单说明")
    private String remark;

    /**
     * create_time
     * 用户下单时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("下单时间")
    private Date createTime;

    /**
     * status
     * 订单状态
     */
    @ApiModelProperty("订单状态:'预约成功','已取消','已完成','配送中','预约中'")
    private String status;

    /**
     * cancel_reason
     * 取消订单原因
     */
    @ApiModelProperty("取消订单原因")
    private String cancelReason;

    /**
     * protocol_url
     * 协议图片路径
     */
    @ApiModelProperty("协议图片路径")
    private String protocolUrl;

    /**
     * is_delete
     * 是否删除,0表示未删除,1表示已经删除
     */
    @ApiModelProperty("是否删除,0表示未删除,1表示已经删除")
    private Byte isDelete;

    @ApiModelProperty("订单修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * car_type
     * 配送车类型
     */
    @ApiModelProperty("配送车类型: '小车（6-10方）','大车（13-15方）'")
    private String carType;

    /**
     * carriage
     * 运费
     */
    @ApiModelProperty("运费")
    private Float carriage;

    /**
     * distance
     * 配送距离
     */
    @ApiModelProperty("配送距离")
    private Float distance;

    /**
     * totalAmount
     * 总金额
     */
    @ApiModelProperty("总金额")
    private Float totalAmount;

    /**
     * distributionPoint
     * 配送点
     */
    @ApiModelProperty("配送点")
    private String distributionPoint;

}