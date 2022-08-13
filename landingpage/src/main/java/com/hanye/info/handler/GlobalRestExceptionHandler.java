package com.hanye.info.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hanye.info.vo.ReturnVo;

@RestControllerAdvice(basePackages= {"com.hanye.info.rest"})
public class GlobalRestExceptionHandler {
	
    @ExceptionHandler(value = { Exception.class })
    public ReturnVo exceptionHandler(Exception e) {
        return new ReturnVo("fail", e.getMessage());
    }
}
