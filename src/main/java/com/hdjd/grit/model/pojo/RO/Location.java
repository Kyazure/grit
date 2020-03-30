package com.hdjd.grit.model.pojo.RO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: yuan
 * @Date: 2020/3/27 12:39
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location implements Serializable {
    private String longitude;
    private String latitude;
}
