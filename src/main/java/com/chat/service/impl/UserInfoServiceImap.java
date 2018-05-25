package com.chat.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chat.common.ParentsServiceImpl;
import com.chat.entity.UserInfo;
import com.chat.exception.MyRuntimeException;
import com.chat.mapper.UserInfoMapper;
import com.chat.service.UserInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chat.util.AccessAddressUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author taotao
 * @since 2018-05-17
 */
@Service
public class UserInfoServiceImap extends ParentsServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
   @Autowired
    private UserInfoMapper userInfoMapper;
    /**
     * 添加用户
     * @param userInfo
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addUserInfo(UserInfo userInfo) throws Exception {
        //判断是否存在
        List<UserInfo> users = userInfoMapper.selectList(new EntityWrapper<UserInfo>()
        .eq("name",userInfo.getName()));
        if (users.size() > 0){
            throw new MyRuntimeException("用户名存在!!");
        }
        userInfo.setPassword(AccessAddressUtil.getBCryptPwd(userInfo.getPassword()));
        Integer insert = userInfoMapper.insert(userInfo);
        if (insert >0){
            return true;
        }
        return false;
    }
}
