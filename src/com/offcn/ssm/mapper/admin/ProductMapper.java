package com.offcn.ssm.mapper.admin;

import java.util.List;
import java.util.Map;

import com.offcn.ssm.pojo.Product;

public interface ProductMapper {

	void addProduct(Product p);

	List<Product> queryAllProduct(int i);

	List<Product> findByPage(Map<String, Object> map);

	int selectCount();

	List<Product> findHotProduct();

	Product findProductByPid(String pid);

	int countProductByCategory(String cid);

	List<Product> listProductByCategory(Map<String, Object> map);

	void updateProduct(Product p);

	void deleteProductByPid(String pid);

	

}
