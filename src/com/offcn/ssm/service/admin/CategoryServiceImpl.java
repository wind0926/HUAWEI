package com.offcn.ssm.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.ssm.mapper.admin.CategoryMapper;
import com.offcn.ssm.pojo.Category;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryMapper mapper ;

	@Override
	public void addCategory(Category c) {
		// TODO Auto-generated method stub
		mapper.addCategory(c);
	}

	@Override
	public List<Category> listCategory() {
		// TODO Auto-generated method stub
		return mapper.listCategory();
	}

	@Override
	public Category queryCategoryByCid(String cid) {
		// TODO Auto-generated method stub
		return mapper.queryCategoryByCid(cid);
	}

	@Override
	public void updateCategory(Category c) {
		// TODO Auto-generated method stub
		mapper.updateCategory(c);
	}

	@Override
	public void delCategory(String cid) {
		// TODO Auto-generated method stub
		mapper.delCategory(cid);
	}

	
}
