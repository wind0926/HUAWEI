package com.offcn.ssm.service.admin;

import java.util.List;

import com.offcn.ssm.pojo.PageBean;
import com.offcn.ssm.pojo.Product;

public interface ProductService {

	void addProduct(Product p);

	PageBean listProduct(int curPage);

	List<Product> findHotProduct();

	Product findProductByPid(String pid);

	PageBean listProductByCategory(String cid, int curPage);

	void updateProduct(Product p);

	void deleteProductByPid(String pid);

	

}
