package com.woniuxy.his.service.impl;

import com.woniuxy.his.entity.Menu;
import com.woniuxy.his.mapper.MenuMapper;
import com.woniuxy.his.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

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
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
	
	@Resource
	private MenuMapper menuMapper;

	@Override
	public List<Menu> selectMenuByRid(Integer rid) throws Exception {		
		List<Menu> list = menuMapper.selectMenuByRid(rid);
		System.out.println(list+"rid");
		ArrayList<Menu> rootList = new ArrayList<Menu>();
		//先取出所有的一级菜单
		for(Menu menu:list) {
			if(menu.getLevel()==1) {
				rootList.add(menu);
				menu.setChildren(new ArrayList<Menu>());
			}
		}
		
		//取出所有的二级菜单
		for(Menu menu:list) {
			if(menu.getLevel()==2) {
				//找到父级菜单对象
				for(Menu root:rootList) {					
					if(root.getId().equals(menu.getPid()) && root.getLevel() == 1) {						
						root.getChildren().add(menu);
						menu.setChildren(new ArrayList<Menu>());
						break;
					}
				}
			}
		}
		//取出所有的三级菜单
		for(Menu menu:list) {
			if(menu.getLevel()==3) {
				//找到二级菜单
				for(Menu level1:rootList) {
					for(Menu level2:level1.getChildren()) {
						if(level2.getId()==menu.getPid()) {
							level2.getChildren().add(menu);
						}
					}
				}
			}
		}
		list=null;		
		return rootList;		
	}

}
