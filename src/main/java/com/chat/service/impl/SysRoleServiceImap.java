package com.chat.service.impl;

import com.chat.entity.SysRole;
import com.chat.mapper.SysRoleMapper;
import com.chat.service.SysRoleService;
import com.chat.common.ParentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author taotao
 * @since 2018-05-23
 */
@Service
public class SysRoleServiceImap extends ParentsServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    /**
     * 通过uid查询角色表
     * @return
     */
    @Autowired
    private  SysRoleMapper sysRoleMapper;
    @Override
    public List<SysRole> selectByUid(long id) {
        return sysRoleMapper.selectByUid(id);
    }
}
