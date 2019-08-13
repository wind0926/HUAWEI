package com.offcn.ssm.mapper.admin;

import java.util.List;

import com.offcn.ssm.pojo.Category;

public interface CategoryMapper {

	void addCategory(Category c);

	List<Category> listCategory();

	Category queryCategoryByCid(String cid);

	void updateCategory(Category c);

	void delCategory(String cid);

}
