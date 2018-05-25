package com.chat.mapper;

import com.chat.common.ParentsMapper;
import com.chat.entity.SysRole;

import java.util.List;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author taotao
 * @since 2018-05-23
 */
public interface SysRoleMapper extends ParentsMapper<SysRole> {

    /**
     * 通过uid查询角色表
     * @return
     */
    public List<SysRole> selectByUid(long id);
}
