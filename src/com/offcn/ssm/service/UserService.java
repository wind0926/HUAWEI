package com.offcn.ssm.service;

import com.offcn.ssm.pojo.User;

public interface UserService {

	void addUser(User user);

	boolean findUserByUsernameAndPassword(User user);

}
