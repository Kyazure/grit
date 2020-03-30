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
@ApiModel(value = "OrdersAndGoods", description = "订单商品模型")
@TableName("orders_goods")
public class OrdersAndGoods implements Serializable {
    /**
     * id
     */
    @TableId
    @ApiModelProperty("订单商品主键")
    private String id;

    /**
     * orders_id
     * 订单id
     */
    @ApiModelProperty("订单id")
    private String ordersId;

    /**
     * goods_id
     * 商品id
     */
    @ApiModelProperty("商品id")
    private String goodsId;

    /**
     * purchase_quantity
     * 购买数量
     */
    @ApiModelProperty("购买商品数量")
    private Float purchaseQuantity;

}