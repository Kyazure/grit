package com.hdjd.grit.model.pojo.RO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName:adminPushMessageRo
 * @author: yeqi
 * @create: 2020/3/25 13:33
 * @description
 */
@Data
@AllArgsConstructor
public class AdminPushMessageRo implements Serializable {
    @JsonProperty("userId")
    private String userId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("remarks")
    private String remarks;
}
