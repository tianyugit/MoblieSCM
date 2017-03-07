package com.sise.dao;

import java.util.List;

import com.sise.pojo.User;

public interface UserDao {
	
	/**
	 * �����û��������û�
	 * @param account �û���
	 * @param conn 
	 * @return ���ҵ����û�,����Ҳ�������null
 	 */
	User findUserByName(String account);
	
	/**
	 * �����û�Id�����û�
	 * @param userId �û�Id
	 * @param conn 
	 * @return ���ҵ����û�,����Ҳ�������null
 	 */
	User findUserById(String userId);

	/**
	 * ����û�
	 * @param user ��װ���û���Ϣ��bean
	 * @param conn 
	 */
	void addUser(User user);
	
	/**
	 * ����idɾ���û�
	 * @param id Ҫɾ�����û�id
	 */
	void delUser(int id);
	
	/**
	 * �����û�����������û�
	 * @param username �û���
	 * @param passwd ����
	 * @return �ҵ����û�bean
	 */
	User finUserByNameAndPsw(String account, String passwd);

	/**
	 * ͨ�����ֺ���������û�
	 * @param account
	 * @param passwd
	 * @return
	 */
	User findAdminByNameAndPsw(String account, String passwd);

	/**
	 * ��ȡ�û��б�
	 * @return
	 */
	List<User> getUserList();

	/**
	 * ���µ�¼�û���ʱ��
	 * @param account
	 */
	void updateLoginTime(String account);

	/**
	 * �����û�
	 * @param user
	 */
	void updateUser(User user);

	/**
	 * �����û�
	 * @param user
	 * @return
	 */
	List<User> findUser(User user);

	/**
	 * ɾ���û�
	 * @param userid
	 */
	void deleteUser(String userid);
	
	/**
	 * ��ҳ
	 * @param start ��ʼλ��
	 * @param size ��Ҫ�ĳ���
	 * @return
	 * @throws Exception
	 */
	public List<User> findAllWithFy(int start,int size) throws Exception;

	/**
	 * ��ȡ��ҳ���ݵ��ܳ��ȴ�С
	 * @return
	 * @throws Exception
	 */
	public int getLong() throws Exception;
}
