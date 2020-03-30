package com.hdjd.grit.core.util;

import com.hdjd.grit.core.ResultInfo;
import com.hdjd.grit.core.constant.ApiConstant;
import com.hdjd.grit.core.exception.ParameterException;

/**
 * @author yuan
 */
public class ResultInfoUtil {

    public static <T> ResultInfo<T> buildError() {
        ResultInfo<T> resultInfo =  build(ApiConstant.ERROR_CODE,
                ApiConstant.ERROR_MESSAGE, null);
        return resultInfo;
    }

    public static <T> ResultInfo<T> buildError(int errorCode, String message) {
        ResultInfo<T> resultInfo =  build(errorCode, message, null);
        return resultInfo;
    }

    public static <T> ResultInfo<T> buildSuccess(T data) {
        ResultInfo<T> resultInfo =  build(ApiConstant.SUCCESS_CODE,
                ApiConstant.SUCCESS_MESSAGE, data);
        return resultInfo;
    }

    public static <T> ResultInfo<T> build(Integer code, String message, T data) {
        if (code == null) {
            throw new ParameterException("必须要定义返回Code.");
        }

        if (message == null) {
            throw new ParameterException("必须要定义返回Message.");
        }
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(code);
        resultInfo.setMessage(message);
        resultInfo.setData(data);
        return resultInfo;
    }

}
