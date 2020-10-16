package com.woniuxy.his.shiro;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.woniuxy.his.entity.User;
import com.woniuxy.his.service.UserService;

import javax.annotation.Resource;
import java.util.List;

public class UserRealm extends AuthorizingRealm {

	@Resource
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//		try {
//			List<Menu> list = userService.selectUserPer((User)principals.getPrimaryPrincipal());
//			System.out.println(list);
//			for(Menu per:list) {
//				simpleAuthorizationInfo.addStringPermission(per.getName());
//				//simpleAuthorizationInfo.addRole(per.get);
//			}
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return simpleAuthorizationInfo;
		
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		try {
			User user = userService.selectUserByTel((String)token.getPrincipal());
		    if(user!=null) {
		    	SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),getName());
		        return info;		    
		    }
		
		
		} catch (Exception e) {
			throw new AuthenticationException("服务器异常");
		}
		return null;
	}
}
