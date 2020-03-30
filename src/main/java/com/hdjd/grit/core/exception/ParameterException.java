package com.hdjd.grit.core.exception;


import com.hdjd.grit.core.constant.ApiConstant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParameterException extends RuntimeException {

    private Integer errorCode;

    public ParameterException() {
        super(ApiConstant.ERROR_MESSAGE);
        this.errorCode = ApiConstant.ERROR_CODE;
    }

    public ParameterException(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public ParameterException(String message) {
        super(message);
        this.errorCode = ApiConstant.ERROR_CODE;
    }

    public ParameterException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
