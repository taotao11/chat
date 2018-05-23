package com.chat.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chat.common.ParentsController;
import com.chat.entity.UserInfo;
import com.chat.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author taotao
 * @since 2018-05-17
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController extends ParentsController<UserInfoService,UserInfo,Long> {
    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/select")
    public UserInfo select(){
        UserInfo userInfo = userInfoService.selectList(new EntityWrapper<UserInfo>()).get(0);

        return userInfo;
    }

}

