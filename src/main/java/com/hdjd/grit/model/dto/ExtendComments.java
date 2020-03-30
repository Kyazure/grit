package com.hdjd.grit.model.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName:ExtendComments
 * @author: yeqi
 * @create: 2020/3/18 9:29
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(value = "ExtendComments", description = "评论扩展模型")
public class ExtendComments implements Serializable {
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

    /**
     * avatar_url
     * 用户头像
     */
    @ApiModelProperty("用户头像路径")
    private String avatarUrl;

    /**
     * name
     * 用户微信名
     */
    @ApiModelProperty("用户微信名")
    private String name;

}

