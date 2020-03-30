package com.hdjd.grit.model.dto;

import com.hdjd.grit.model.pojo.RO.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yuan
 * @Date: 2020/3/27 12:40
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@Builder
public class ExtendBattle implements Serializable {
    private String id;
    private String name;
    private Location location;
}
