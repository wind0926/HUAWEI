package com.offcn.ssm.controller.admin;

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
@RequestMapping("/admin")
public class AdminController {
	
	
	
	@RequestMapping("/addProduct")
	public String addProduct() {
		return "admin/product/add";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "admin/home";
	}
	
	@RequestMapping("/top")
	public String top() {
		return "admin/top";
	}
	@RequestMapping("/bottom")
	public String bottom() {
		return "admin/bottom";
	}
	@RequestMapping("/left")
	public String left() {
		return "admin/left";
	}
	@RequestMapping("/welcome")
	public String welcome() {
		return "admin/welcome";
	}
	
	

}
