package com.offcn.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.offcn.ssm.pojo.Car;
import com.offcn.ssm.pojo.CarItem;
import com.offcn.ssm.pojo.Product;
import com.offcn.ssm.service.admin.ProductService;

@RequestMapping("car")
@Controller
public class CarController {
	
	@Autowired
	ProductService service;
	
	
	@RequestMapping("/addCar")
	public ModelAndView addCar(String pid, int count,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		//通过pid找到商品内容
		Product p = service.findProductByPid(pid);
		
		//将count加入到购物车中
		CarItem item = new CarItem();
		item.setProduct(p);
		item.setCount(count);
		//将购物车项加入到购物车
		Car car=(Car) session.getAttribute("car");
		if (car==null) {
			car=new Car();
		}
		
		car.add2Car(item);
		session.setAttribute("car", car);
		
		
		
		
		mav.setViewName("cart");
		return mav;
	}
	@RequestMapping("/showCar")
	public String showCar() {
		return "cart";
	}
	
	@RequestMapping("/delcar")
	public String delCar(String pid,HttpSession session) {
		
		Car car=(Car) session.getAttribute("car");
		
		car.remove(pid);
		
		
		return "cart";
	}

	@RequestMapping("/clearcar")
	public String clearCar(String pid,HttpSession session) {
		
		Car car=(Car) session.getAttribute("car");
		
		car.clear();
		
		
		return "cart";
	}
}
