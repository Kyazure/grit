package com.hdjd.grit.core.exception;


import com.hdjd.grit.core.ResultInfo;
import com.hdjd.grit.core.util.ResultInfoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // 将输出的内容写入ResponseBody中
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ParameterException.class)
    public ResultInfo<String> handlerParameterException(ParameterException ex) {
        ResultInfo<String> resultInfo = ResultInfoUtil.buildError(ex.getErrorCode(), ex.getMessage());
        return resultInfo;
    }

    @ExceptionHandler(Exception.class)
    public ResultInfo<String> handlerException(Exception ex) {
        log.info("未知异常：{}", ex);
        ResultInfo<String> resultInfo = ResultInfoUtil.buildError();
        return resultInfo;
    }

}
