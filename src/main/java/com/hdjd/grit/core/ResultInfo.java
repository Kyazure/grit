package com.hdjd.grit.core;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author yuan
 */
@Getter
@Setter
public class ResultInfo<T> implements Serializable {

    private Integer code;
    private String message;
    private T data;

}
