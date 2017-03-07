package com.test.dao;

import com.test.pojo.User;

public interface UserDao {
	
	public User findUserById(int id) throws Exception;

}
