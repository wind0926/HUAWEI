package com.offcn.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.offcn.ssm.pojo.Category;
import com.offcn.ssm.service.admin.CategoryService;

@Controller

public class CategroyController {
	
	@Autowired
	CategoryService service;

	// 返回值响应为 json格式
	@RequestMapping("/findAllCategory")
	public @ResponseBody List<Category> findAllCategory(){
		return service.listCategory();
	}
	
	
	
}
