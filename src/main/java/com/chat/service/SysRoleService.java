package com.chat.service;

import com.chat.entity.SysRole;
import com.chat.common.ParentsService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author taotao
 * @since 2018-05-23
 */
public interface SysRoleService extends ParentsService<SysRole> {
    /**
     * 通过uid查询角色表
     * @return
     */
    public List<SysRole> selectByUid(long id);
}
