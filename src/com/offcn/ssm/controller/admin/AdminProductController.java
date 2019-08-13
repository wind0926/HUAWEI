package com.offcn.ssm.controller.admin;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.offcn.ssm.pojo.Category;
import com.offcn.ssm.pojo.PageBean;
import com.offcn.ssm.pojo.Product;
import com.offcn.ssm.service.admin.ProductService;
import com.offcn.ssm.util.UUIDUtil;

@Controller
@RequestMapping("/admin")
public class AdminProductController {

	@Autowired
	ProductService service;

	@RequestMapping("/showAddProduct")
	public String showAddProduct() {
		return "admin/product/add";
	}

	@RequestMapping("/listProduct")
	public ModelAndView listProduct(int curPage) {
		ModelAndView mav = new ModelAndView();
		PageBean page = service.listProduct(curPage);
		mav.setViewName("admin/product/list");
		mav.addObject("page", page);
		return mav;
	}

	@RequestMapping("/addProducts")
	public ModelAndView addProduct(Product p, String cid, MultipartFile pictrueFile)
			throws IllegalStateException, IOException {

		// 璁剧疆鍥剧墖鍚嶇О锛屼笉鑳介噸澶嶏紝浣跨敤 uuid
		String picName = UUIDUtil.getUUId();

		// 鑾峰彇鎻愪氦涓婃潵鐨勬枃浠跺悕
		String oriName = pictrueFile.getOriginalFilename();

		// 閫氳繃鏂囦欢鍚嶈幏鍙栧悗缂�鍚�
		String extName = oriName.substring(oriName.lastIndexOf("."));

		// 涓婁紶鍥剧墖
		pictrueFile.transferTo(new File("C:\\Users\\A\\Desktop\\xiaomi\\WebContent\\pic\\" + picName + extName));

		p.setPid(UUIDUtil.getUUId());

		p.setPimage(picName + extName);

		Category c = new Category();

		c.setCid(cid);

		p.setCategory(c);

		p.setPdate(new SimpleDateFormat("yyyy骞碝M鏈坉d鏃� HH:mm:ss").format(new Date()));

		ModelAndView mav = new ModelAndView();

		service.addProduct(p);

		mav.addObject("msg", "娣诲姞鍟嗗搧鎴愬姛");

		mav.setViewName("admin/welcome");

		return mav;
	}

	@RequestMapping("/editProduct")
	public ModelAndView editProduct(String pid) {
		ModelAndView mav = new ModelAndView();
		Product p = service.findProductByPid(pid);
		System.out.println(p);
		mav.addObject("product", p);
		mav.setViewName("admin/product/edit");
		return mav;
	}

	@RequestMapping("/updateProduct")
	public ModelAndView updataProduct(Product p, MultipartFile pictrueFile) throws IllegalStateException, IOException {
		ModelAndView mav = new ModelAndView();
		// 璁剧疆鍥剧墖鍚嶇О锛屼笉鑳介噸澶嶏紝浣跨敤 uuid
		String picName = UUIDUtil.getUUId();

		// 鑾峰彇鎻愪氦涓婃潵鐨勬枃浠跺悕
		String oriName = pictrueFile.getOriginalFilename();

		// 閫氳繃鏂囦欢鍚嶈幏鍙栧悗缂�鍚�
		String extName = oriName.substring(oriName.lastIndexOf("."));

		// 涓婁紶鍥剧墖
		pictrueFile.transferTo(new File("F:\\Javasource\\xiaomi\\WebContent\\pic\\" + picName + extName));

		p.setPimage(picName + extName);

		service.updateProduct(p);

		System.out.println(p);
		mav.addObject("msg", "淇敼鎴愬姛");
		mav.setViewName("admin/welcome");
		return mav;
	}

	@RequestMapping("/delProduct")
	public ModelAndView delProduct(String pid) {
		ModelAndView mav = new ModelAndView();

		service.deleteProductByPid(pid);

		mav.addObject("msg", "鍒犻櫎鎴愬姛!");
		mav.setViewName("admin/welcome");

		return mav;
	}
}
