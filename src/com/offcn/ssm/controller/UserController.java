package com.offcn.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.offcn.ssm.pojo.User;
import com.offcn.ssm.service.UserService;
import com.offcn.ssm.util.UUIDUtil;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	@RequestMapping("/regist")
	public String regist() {
		return "regist";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	
	@RequestMapping("/doLogin")
	public ModelAndView doLogin(User user,HttpSession session) { /* username   password  */
		
		// 数据验证 (略)
		boolean isSuccess = service.findUserByUsernameAndPassword(user);
		ModelAndView mav = new ModelAndView();
		if(isSuccess) {
			// 成功
			mav.addObject("msg", "登录成功");
			// 添加到session
			session.setAttribute("user", user);
		}else {
			// 失败
			mav.addObject("msg","登录失败");
		}
		mav.setViewName("msg");
		return mav;
	}
	
	@RequestMapping("/doRegist")
	public ModelAndView  doRegist(User user) {
		// 给新用户设定uid
		user.setUid(UUIDUtil.getUUId());
		ModelAndView mav = new ModelAndView();
		// 后台数据验证
		// 通过service 添加具体的内容
		service.addUser(user);
		
		// 添加信息
		mav.addObject("msg","注册成功！");
		// 添加视图
		mav.setViewName("msg");
		return mav;
	}
	
	@RequestMapping("logout")
	public String doLogout(HttpSession session) {
		session.removeAttribute("user");
		session.invalidate();
		return "index";
	}
	
	

}
