package com.chat.service;

import com.chat.common.ParentsService;
import com.chat.entity.UserInfo;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author taotao
 * @since 2018-05-17
 */
public interface UserInfoService extends ParentsService<UserInfo> {
    /**
     * 添加用户
     * @param userInfo
     * @return
     * @throws Exception
     */
    public boolean addUserInfo(UserInfo userInfo) throws Exception;

}
