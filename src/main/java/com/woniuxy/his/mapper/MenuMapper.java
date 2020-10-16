package com.woniuxy.his.mapper;

import com.woniuxy.his.entity.Menu;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liushaoqi
 * @since 2020-10-12
 */
public interface MenuMapper extends BaseMapper<Menu> {
	public List<Menu> selectMenuByRid(Integer rid) throws Exception;

}
