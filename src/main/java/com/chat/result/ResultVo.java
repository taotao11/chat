package com.chat.result;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

/**
 * 返回结果类
 */
public class ResultVo {
    @JsonView(View.Result.class)
    //信息
    private String message;

    @JsonView(View.Result.class)
    //状态
    private Integer status;

    @JsonView(View.Result.class)
    //数据
    private Object date;
    @JsonView(View.Result.class)
    //总条数
    private Integer totle;
    @JsonView(View.Result.class)
    //当前页
    private Integer current;



    public ResultVo setTotal(Integer totle){
        this.setTotle(totle);
        return this;
    }
    public ResultVo setCurrents(Integer current){

        this.setCurrent(current);
        return this;
    }
    //发生错误时调用方法
    public static ResultVo error(Integer status,String message){
       ResultVo resultVo = new  ResultVo(message,status,null);

       return resultVo;
    }
    //成功时调用方法
    public static ResultVo success(Integer status,String message,Object date){
        ResultVo resultVo = new  ResultVo(message,status,date);

        return resultVo;
    }

    public ResultVo(String message, Integer status, Object date) {
        this.message = message;
        this.status = status;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }
    public Integer getTotle() {
        return totle;
    }

    public void setTotle(Integer totle) {
        this.totle = totle;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }
}
