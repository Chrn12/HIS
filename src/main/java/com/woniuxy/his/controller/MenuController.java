package com.woniuxy.his.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.his.entity.Menu;
import com.woniuxy.his.entity.User;
import com.woniuxy.his.service.MenuService;
import com.woniuxy.his.utils.JsonResult;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liushaoqi
 * @since 2020-10-12
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Resource
	private MenuService menuService;
	
	@GetMapping
	public JsonResult selectMenu() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		User user = (User)subject.getPrincipal();
		List<Menu> list = menuService.selectMenuByRid(user.getRid());		
		return new JsonResult("200","登陆成功",list,null);	
		
	}

}

