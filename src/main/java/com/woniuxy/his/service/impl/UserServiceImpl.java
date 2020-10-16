package com.woniuxy.his.service.impl;

import com.woniuxy.his.entity.User;
import com.woniuxy.his.mapper.UserMapper;
import com.woniuxy.his.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liushaoqi
 * @since 2020-10-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	@Resource
	private UserMapper userMapper;

	@Override
	public User selectUserByTel(String tel) {		
		QueryWrapper<User> queryWrapper =new QueryWrapper<User>();
		queryWrapper.eq("tel", tel);
		User user = userMapper.selectOne(queryWrapper);

		return user;
	}

}
