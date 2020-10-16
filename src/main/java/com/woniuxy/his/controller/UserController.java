package com.woniuxy.his.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.his.entity.User;
import com.woniuxy.his.service.UserService;
import com.woniuxy.his.utils.JsonResult;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
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
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	
	@RequestMapping("login")
	public JsonResult login(User user,Boolean rememberme) throws Exception {
		
		UsernamePasswordToken token = new UsernamePasswordToken(user.getTel(),user.getPassword(),rememberme);		
		Subject subject = SecurityUtils.getSubject();
		if(!subject.isAuthenticated() && !subject.isRemembered()) {
			subject.login(token);
		}
		
		return new JsonResult("200","登陆成功",null,null);					

	
	}

}

