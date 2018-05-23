package com.chat.common;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * 实现类包装
 */
public class ParentsServiceImpl<M extends BaseMapper<T>,T> extends ServiceImpl<M,T> implements ParentsService<T> {
}
