package com.tyb.fishhost.expand;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理
 *
 * @author 陈小伟
 */
@RestControllerAdvice
@Component
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public BaseResponse handleNotFoundException(Exception ex) {
        BaseResponse responseMsg = new BaseResponse(ex.getMessage());
        return responseMsg;
    }

}


