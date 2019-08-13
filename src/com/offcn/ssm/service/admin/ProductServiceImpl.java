package com.offcn.ssm.service.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.ssm.mapper.admin.CategoryMapper;
import com.offcn.ssm.mapper.admin.ProductMapper;
import com.offcn.ssm.pojo.Category;
import com.offcn.ssm.pojo.PageBean;
import com.offcn.ssm.pojo.Product;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductMapper mapper;
	
	@Autowired
	CategoryMapper cmapper;

	@Override
	public void addProduct(Product p) {
		// TODO Auto-generated method stub
		mapper.addProduct(p);
	}

	/*
	 * (non-Javadoc)
	 * @see com.offcn.ssm.service.admin.ProductService#listProduct(int)
	 * 查询当前页面的内容，并加载到PageBean中
	 */
	
	@Override
	public PageBean listProduct(int curPage) {
		PageBean<Product> page = new PageBean<Product>();
		
		// 封装当前页数
		page.setCurPage(curPage);
		
		// 封装的总记录数
		int totalCount = mapper.selectCount();
		page.setTotalSize(totalCount); // 查询总的记录数
		
		// 计算总页数
		double total = totalCount;
		int totalPage = (int)Math.ceil(total/ PageBean.pageSize);
		page.setTotalPage(totalPage);
		
		Map<String,Object> map = new HashMap<String,Object>(); 
		map.put("start", (curPage - 1) * PageBean.pageSize);
		map.put("size", PageBean.pageSize);
		
		List<Product> list = mapper.findByPage(map); // 查询数据
		
		page.setList(list);
		
		System.out.println(page);
		
		return page;
	}

	@Override
	public List<Product> findHotProduct() {
		// TODO Auto-generated method stub
		return mapper.findHotProduct();
	}

	@Override
	public Product findProductByPid(String pid) {
		// TODO Auto-generated method stub
		Product p = mapper.findProductByPid(pid);
		System.out.println(p);
		Category c = cmapper.queryCategoryByCid(p.getCid());
		p.setCategory(c);
		return p;
	}

	@Override
	public PageBean listProductByCategory(String cid, int curPage) {
		PageBean<Product> page = new PageBean<Product>();
		// 封装当前页数
		page.setCurPage(curPage);
		
		// 封装的总记录数
		int totalCount = mapper.countProductByCategory(cid);
		page.setTotalSize(totalCount); // 查询总的记录数
		
		// 计算总页数
		double total = totalCount;
		int totalPage = (int)Math.ceil(total/ PageBean.pageSize);
		page.setTotalPage(totalPage);
		
		Map<String,Object> map = new HashMap<String,Object>(); 
		map.put("start", (curPage - 1) * PageBean.pageSize);
		map.put("size", PageBean.pageSize);
		map.put("cid", cid);
		
		List<Product> list = mapper.listProductByCategory(map); // 查询数据
		
		page.setList(list);
		
		System.out.println(page);
		
		return page;
	}

	@Override
	public void updateProduct(Product p) {
		// TODO Auto-generated method stub
		mapper.updateProduct(p);
	}

	@Override
	public void deleteProductByPid(String pid) {
		// TODO Auto-generated method stub
		mapper.deleteProductByPid(pid);
	}
	

	
}
