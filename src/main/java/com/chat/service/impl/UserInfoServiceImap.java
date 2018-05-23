package com.chat.service.impl;

import com.chat.common.ParentsServiceImpl;
import com.chat.entity.UserInfo;
import com.chat.mapper.UserInfoMapper;
import com.chat.service.UserInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
