package com.chat.exception;

/**
 * 自定义run异常
 */
public class MyRuntimeException extends RuntimeException {

    public MyRuntimeException(String message){
        super(message);
    }

}
