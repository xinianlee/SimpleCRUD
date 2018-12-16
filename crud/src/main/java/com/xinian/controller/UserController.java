package com.xinian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author xinian
 * @date 2018/12/14 23:07
 */
@RequestMapping("/user")
@Controller
public class UserController {

	@PostMapping(value = "/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
						Map<String,Object> Map, HttpSession session){
		if(!StringUtils.isEmpty(username) && "123456".equals(password)){
			//登录成功
			session.setAttribute("loginuser",username);
			return "redirect:/main.html";
		}else{
			//登录失败
			Map.put("msg","用户名密码错误");
			return "index.html";
		}

	}
}
