package com.offcn.ssm.mapper;

import com.offcn.ssm.pojo.User;

public interface UserMapper {

	void addUser(User user);

	int findUserByUsernameAndPassword(User user);

}
