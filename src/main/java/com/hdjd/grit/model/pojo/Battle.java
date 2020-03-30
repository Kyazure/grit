package com.hdjd.grit.model.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @Author: yuan
 * @Date: 2020/3/27 12:35
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@ApiModel(value = "Battle", description = "沙场模型")
@TableName("battle")
public class Battle implements Serializable {
    /**
     * id
     *
     */
    @TableId
    @ApiModelProperty("沙场主键")
    private String id;

    /**
     * name
     * 沙场名称
     */
    @ApiModelProperty("沙场名称")
    private String name;

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
