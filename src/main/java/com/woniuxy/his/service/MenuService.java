package com.woniuxy.his.service;

import com.woniuxy.his.entity.Menu;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liushaoqi
 * @since 2020-10-12
 */
public interface MenuService extends IService<Menu> {
	public List<Menu> selectMenuByRid(Integer rid) throws Exception;

}
