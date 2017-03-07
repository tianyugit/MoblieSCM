package com.sise.dao;

import java.util.List;

import com.sise.pojo.User;

public interface UserDao {
	
	/**
	 * 根据用户名查找用户
	 * @param account 用户名
	 * @param conn 
	 * @return 查找到的用户,如果找不到返回null
 	 */
	User findUserByName(String account);
	
	/**
	 * 根据用户Id查找用户
	 * @param userId 用户Id
	 * @param conn 
	 * @return 查找到的用户,如果找不到返回null
 	 */
	User findUserById(String userId);

	/**
	 * 添加用户
	 * @param user 封装了用户信息的bean
	 * @param conn 
	 */
	void addUser(User user);
	
	/**
	 * 根据id删除用户
	 * @param id 要删除的用户id
	 */
	void delUser(int id);
	
	/**
	 * 根据用户名密码查找用户
	 * @param username 用户名
	 * @param passwd 密码
	 * @return 找到的用户bean
	 */
	User finUserByNameAndPsw(String account, String passwd);

	/**
	 * 通过名字和密码查找用户
	 * @param account
	 * @param passwd
	 * @return
	 */
	User findAdminByNameAndPsw(String account, String passwd);

	/**
	 * 获取用户列表
	 * @return
	 */
	List<User> getUserList();

	/**
	 * 更新登录用户名时间
	 * @param account
	 */
	void updateLoginTime(String account);

	/**
	 * 更新用户
	 * @param user
	 */
	void updateUser(User user);

	/**
	 * 查找用户
	 * @param user
	 * @return
	 */
	List<User> findUser(User user);

	/**
	 * 删除用户
	 * @param userid
	 */
	void deleteUser(String userid);
	
	/**
	 * 分页
	 * @param start 开始位置
	 * @param size 需要的长度
	 * @return
	 * @throws Exception
	 */
	public List<User> findAllWithFy(int start,int size) throws Exception;

	/**
	 * 获取分页数据的总长度大小
	 * @return
	 * @throws Exception
	 */
	public int getLong() throws Exception;
}
