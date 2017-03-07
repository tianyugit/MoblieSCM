package com.sise.service;

import java.util.List;

import com.sise.dao.UserDao;
import com.sise.pojo.User;

public class UserManageServiceImpl implements UserManageService{
	
	private UserDao userDao ;

	public void regist(User user) {
		
		userDao.addUser(user);
		System.out.println("ddd");
	}

	public User findUserByName(String account) {
		User user = userDao.findUserByName(account);
		return user;
	}
	
	public String finUserByNameAndPsw(User user) {
		User user1 = userDao.finUserByNameAndPsw(user.getAccount(),user.getPasswd());
		if(user1 == null){
			return "<font color='red' size='2'>用户名或密码不正确!!</font>";
		}else if("1".equals(user1.getStatus())){
			return null;
		}else{
			return "warn";
		}
	}
	
	public List<User> getList() {
		return userDao.getUserList();
	}

	
	public String findAdminByNameAndPsw(User user) {
		User user1 = userDao.findAdminByNameAndPsw(user.getAccount(),user.getPasswd());
		if(user1 == null){
			return "<font color='red' size='2'>用户名或密码不正确!</font>";
		}
		return null;
	}
	public void updateLoginTime(String account) {
		userDao.updateLoginTime(account);
		
	}
	
	public User findUserById(String userid) {
		return userDao.findUserById(userid);
	}
	
	public void setUserDao(UserDao userDao) {
			this.userDao = userDao;
		}

	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}

	public List<User> findUser(User user) {
		return userDao.findUser(user);
	}

	public void addUser(User user) {
		userDao.addUser(user);
		
	}

	public void deleteUser(String userid) {
		// TODO Auto-generated method stub
		userDao.deleteUser(userid);
		
	}

	public List<User> findAllWithFy(int start, int size) throws Exception{
		return userDao.findAllWithFy(start, size);
	}
	
}
