package com.woniuxy.his.exception;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.woniuxy.his.utils.JsonResult;

@RestControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler({BindException.class,IllegalStateException.class})
    public String validException(Exception e){
        e.printStackTrace();
        return "参数异常";
    }
    @ExceptionHandler(Exception.class)
    public JsonResult ExceptionAll(Exception e){
        if(e instanceof UnknownAccountException){
            e.printStackTrace();
            return  new JsonResult("500","用户名不存在",null,null);
        }
        if(e instanceof IncorrectCredentialsException){
            e.printStackTrace();
            return  new JsonResult("500","用户名密码不匹配",null,null);
        }
        if(e instanceof AuthorizationException){
            e.printStackTrace();
            return  new JsonResult("500","权限不足",null,null);
        }
        e.printStackTrace();
        return  new JsonResult("500","服务器异常",null,null);
    }

}
