package com.offcn.ssm.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.offcn.ssm.pojo.Category;
import com.offcn.ssm.service.admin.CategoryService;
import com.offcn.ssm.util.UUIDUtil;

@Controller
@RequestMapping("/admin")
public class AdminCategroyController {
	
	@Autowired
	CategoryService service;

	@RequestMapping("/addCategory")
	public String addCategory() {
		return "admin/category/add";
	}
	
	@RequestMapping("/editCategory")
	public ModelAndView editCategory(String cid) {
		ModelAndView mav = new ModelAndView();
		Category c = service.queryCategoryByCid(cid);
		System.out.println(c);
		mav.setViewName("admin/category/edit");
		mav.addObject("category",c);
		return mav;
	}
	
	@RequestMapping("/listCategory")
	public ModelAndView listCategory() {
		ModelAndView mav = new ModelAndView();
		List<Category> list = service.listCategory();
		mav.setViewName("admin/category/list"); // 要显示的视图
		mav.addObject("list", list); // 交给视图显示的数据
		return mav;
	}
	
	@RequestMapping("/saveCategory")
	public ModelAndView saveCategroy(Category c) {
		ModelAndView mav = new ModelAndView();
		c.setCid(UUIDUtil.getUUId());
		System.out.println(c);
		service.addCategory(c);
		mav.addObject("msg", "添加成功");
		mav.setViewName("admin/welcome");
		return mav;
	}
	
	@RequestMapping("/updateCategory")
	public ModelAndView updateCategory(Category c) {
		ModelAndView mav = new ModelAndView();
		service.updateCategory(c);
		mav.addObject("msg", "修改成功");
		mav.setViewName("admin/welcome");
		return mav;
	}
	
	@RequestMapping("/delCategory")
	public ModelAndView delCategory(String cid) {
		ModelAndView mav = new ModelAndView();
		service.delCategory(cid);
		mav.addObject("msg", "删除成功");
		mav.setViewName("admin/welcome");
		return mav;
	}
	
	
	
	
	
	
}
