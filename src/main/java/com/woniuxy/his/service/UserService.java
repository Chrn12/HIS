package com.woniuxy.his.service;

import com.woniuxy.his.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liushaoqi
 * @since 2020-10-12
 */
public interface UserService extends IService<User> {
	public User selectUserByTel(String tel);

}
