package com.fire.controller;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fire.model.Result;
import com.fire.model.VueLoginInfo;
import com.fire.tools.ResultFactory;

@Controller
public class VueLoginController {
	/**
     * 登录控制器，前后端分离用的不同协议和端口，所以需要加入@CrossOrigin支持跨域。
     * 给VueLoginInfoVo对象加入@Valid注解，并在参数中加入BindingResult来获取错误信息。
     * 在逻辑处理中我们判断BindingResult知否含有错误信息，如果有错误信息，则直接返回错误信息。
     * @CrossOrigin(origins = "http://domain2.com", maxAge = 3600)
     */
	@CrossOrigin
	@RequestMapping(value="/login1",method=RequestMethod.POST,produces="application/json; charset=UTF-8")
	@ResponseBody
	public Result login(@Valid@RequestBody VueLoginInfo loginInfo,BindingResult bindingResult){
		
		if(bindingResult.hasErrors()){
			 String message = String.format("登陆失败，详细信息[%s]。", bindingResult.getFieldError().getDefaultMessage());
			 return ResultFactory.buildFailResult(message);
		}
		
		if (!Objects.equals("javalsj", loginInfo.getUserName()) || !Objects.equals("123456", loginInfo.getPassword())) {
            String message = String.format("登陆失败，详细信息[用户名、密码信息不正确]。");
            return ResultFactory.buildFailResult(message);
        }
		return ResultFactory.buildSuccessResult("登陆成功。");
	}
}
