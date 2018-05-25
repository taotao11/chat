package com.chat.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chat.common.ParentsController;
import com.chat.entity.UserInfo;
import com.chat.exception.MyException;
import com.chat.exception.MyRuntimeException;
import com.chat.rabbitmq.Sender;
import com.chat.result.ResultVo;
import com.chat.service.UserInfoService;
import com.chat.util.Constant;
import com.chat.util.ServiceInfoUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author taotao
 * @since 2018-05-17
 */
@Api(value = "用户类接口")
@RestController
@RequestMapping("/userInfo")
public class UserInfoController extends ParentsController<UserInfoService,UserInfo,Long> {
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    Sender sender;
    @GetMapping("/select")
    public UserInfo select(){
        UserInfo userInfo = userInfoService.selectList(new EntityWrapper<UserInfo>()).get(0);

        return userInfo;
    }
    @GetMapping("/port")
    public Integer getPort(){
        System.out.println(ServiceInfoUtil.getPort());
        return ServiceInfoUtil.getPort();

    }

    /**
     * 添加
     * @return
     */
    @ApiOperation(value = "注册")
    @PostMapping("/reg")
    public ResultVo addUserInfo(@RequestBody UserInfo userInfo)throws Exception{
        userInfo.setCreatTime(new Date());
        userInfo.setType(Constant.TYPE_XX);
        userInfo.setIsDelete(Constant.IS_DELETE_FALSE);
        boolean add = userInfoService.addUserInfo(userInfo);
        if (add){
            //rabbitMq 消息中间件
            sender.send(userInfo.getEmail());
            return ResultVo.success(HttpStatus.SC_OK,"注册成功!!!",null);
        }else {
            return ResultVo.error(HttpStatus.SC_HTTP_VERSION_NOT_SUPPORTED,"注册失败,请重试!!!");
        }
    }
    /**
     * 异常测试
     */
    @ApiOperation(value = "测试全局异常")
    @GetMapping("/error")
    public ResultVo error(int id)throws Exception{
        if (id == 1){
           throw new MyException("id不能为1");
        }
        if (id == 2){
            new MyRuntimeException("id不能为2");
        }
        return  ResultVo.success(HttpStatus.SC_OK,"success",id);
    }
}

