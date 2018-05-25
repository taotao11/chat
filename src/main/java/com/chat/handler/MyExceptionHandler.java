package com.chat.handler;

import com.chat.result.ResultVo;
import com.chat.util.AccessAddressUtil;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常处理类
 */
@ControllerAdvice
@ResponseBody
public class MyExceptionHandler {
    //日志
    private static Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    public ResultVo myExceptionHandler(HttpServletRequest request,Exception e) throws Exception {
        logger.error("ip:{},Request URL:{},Exception :{}", AccessAddressUtil.getIpAddress(request),request.getRequestURI(),e.getMessage());
        //过滤指定状态码异常
        if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null){
            throw e;
        }
        return ResultVo.error(HttpStatus.SC_INTERNAL_SERVER_ERROR,e.getMessage());
    }

}
