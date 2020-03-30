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
@ApiModel(value = "Goods", description = "商品模型")
@TableName("goods")
public class Goods implements Serializable {
    /**
     * id
     * 
     */
    @TableId
    @ApiModelProperty("商品主键")
    private String id;

    /**
     * goods_name
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    private String goodsName;

    /**
     * sale_price
     * 单价
     */
    @ApiModelProperty("商品单价")
    private Float salePrice;

    /**
     * amount
     * 数量
     */
    @ApiModelProperty("库存数量")
    private Float amount;

    /**
     * monthy_sales
     * 月销量
     */
    @ApiModelProperty("月销量")
    private Float monthySales;

    /**
     * note
     * 备注
     */
    @ApiModelProperty("商品说明")
    private String note;

    /**
     * image
     * 图片
     */
    @ApiModelProperty("商品图片路径")
    private String image;

    /**
     * deliver_cost
     * 配送费
     */
    @ApiModelProperty("商品配送费")
    private Float deliverCost;

    /**
     * property_nature
     * 商品类型
     */
    @ApiModelProperty("商品类型:'加气块','水泥砖','水泥','砂石'")
    private String goodsType;

    /**
     * property_nature
     * 商品计数单位
     */
    @ApiModelProperty("商品计数单位")
    private String unit;

}