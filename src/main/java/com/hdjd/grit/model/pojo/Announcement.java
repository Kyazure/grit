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
@ApiModel(value = "Announcement", description = "公告模型")
@TableName("announcement")
public class Announcement implements Serializable {
    /**
     * id
     * 
     */
    @TableId
    @ApiModelProperty("公告主键")
    private String id;

    /**
     * title
     * 公告标题
     */
    @ApiModelProperty("公告标题")
    private String title;

    /**
     * content
     * 公告内容
     */
    @ApiModelProperty("公告内容")
    private String content;

    /**
     * create_time
     * 公告时间
     */
    @ApiModelProperty("公告发布时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * update_time
     * 
     */
    @ApiModelProperty("公告修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}