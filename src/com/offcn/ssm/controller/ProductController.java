package com.offcn.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.offcn.ssm.pojo.PageBean;
import com.offcn.ssm.pojo.Product;
import com.offcn.ssm.service.admin.ProductService;

@Controller
public class ProductController {  
	
	@Autowired
	ProductService service;
	

	@RequestMapping("/hotProduct")
	public @ResponseBody List<Product> findHotProduct(){
		return service.findHotProduct();
	}
	
	@RequestMapping("/infoProduct")
	public ModelAndView getProdcutByPid(String pid) {
		ModelAndView mav = new ModelAndView();
		Product product = service.findProductByPid(pid);
		
		mav.addObject("p", product);
		mav.setViewName("product_info");
		return mav;
	}
	
	@RequestMapping("/listProductByCategory")
	public ModelAndView listProductByCategory(String cid,int curPage) {
		ModelAndView mav = new ModelAndView();
		PageBean page = service.listProductByCategory(cid,curPage);
		
		mav.addObject("page", page);
		mav.setViewName("product_list");
		return mav;
	}
	
	
}
