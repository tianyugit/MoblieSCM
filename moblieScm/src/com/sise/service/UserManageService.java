package com.sise.service;

import java.util.List;

import com.sise.pojo.User;



public interface UserManageService {

 	
 	
 	/**
	 * 注册用户
	 * @param user 封装了用户数据的userbean
	 */
	void regist(User user);
	
	User findUserByName(String account);

	String finUserByNameAndPsw(User user);

	String findAdminByNameAndPsw(User user);
	
	List<User> getList();

	void updateLoginTime(String account);

	User findUserById(String userid);

	void updateUser(User user);

	List<User> findUser(User user);

	void addUser(User user);

	void deleteUser(String userid);
	
	List<User> findAllWithFy(int start, int size) throws Exception;
}
