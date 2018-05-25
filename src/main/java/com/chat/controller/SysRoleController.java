package com.chat.controller;


import com.chat.common.ParentsController;
import com.chat.entity.SysRole;
import com.chat.service.SysRoleService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author taotao
 * @since 2018-05-17
 */
@Api(value = "角色操作接口")
@Controller
@RequestMapping("/sysRole")
public class SysRoleController extends ParentsController<SysRoleService,SysRole,Long> {

}

