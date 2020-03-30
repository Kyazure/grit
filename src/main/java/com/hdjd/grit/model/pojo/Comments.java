package com.hdjd.grit.model.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@ApiModel(value = "Comments", description = "评论模型")
@TableName("comments")
public class Comments implements Serializable {
    /**
     * id
     * 
     */
    @TableId
    @ApiModelProperty("评论主键")
    private String id;

    /**
     * user_id
     * 用户id
     */
    @ApiModelProperty("用户id")
    private String userId;

    /**
     * content
     * 评论内容
     */
    @ApiModelProperty("评论内容")
    private String content;

    /**
     * delivery
     * 配送评分
     */
    @ApiModelProperty("配送评分")
    private Float delivery;

    /**
     * server
     * 服务评分
     */
    @ApiModelProperty("服务评分")
    private Float server;

    /**
     * create_time
     * 评论时间时间
     */
    @ApiModelProperty("评论时间")
    private Date createTime;

    /**
     * update_time
     * 
     */
    @ApiModelProperty("修改时间")
    private Date updateTime;
}