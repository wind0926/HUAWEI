package com.offcn.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.ssm.mapper.UserMapper;
import com.offcn.ssm.pojo.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserMapper mapper ;

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		mapper.addUser(user);
	}

	@Override
	public boolean findUserByUsernameAndPassword(User user) {
		
		int count = mapper.findUserByUsernameAndPassword(user);
		
		if(count > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	

}
