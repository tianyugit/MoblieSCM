package com.sise.dao;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.omg.CORBA.Object;

import com.sise.pojo.User;
import com.sise.utils.StringUtils;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{
	
	

	public User findUserByName(String account) {
		SqlSession sqlsession = this.getSqlSession();
		return sqlsession.selectOne("test.findUserByName", account);
	}

	public void addUser(User user) {
		SqlSession sqlsession = this.getSqlSession();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");//设置日期格式
	/*	String str = df.format(new Date());
		   Date date = null;
		   try {
		    date = df.parse(str);
		    user.setCreatetime(date);
		   } catch (ParseException e) {
		    e.printStackTrace();
		   }*/
		//System.out.println(user.getAccount());
	//	Date date = new Date(); 
		//Timestamp timestamp = new Timestamp(date.getTime()); //2013-01-14 22:45:36
		user.setCreatetime(df.format(new Date()));
		user.setUserid(StringUtils.uniqueKey());
		sqlsession.insert("test.addUser",user);
		
	}
	public void delUser(int id) {
		// TODO Auto-generated method stub
		
	}

	public User finUserByNameAndPsw(String account, String passwd) {
		SqlSession sqlsession = this.getSqlSession();
		Map<String, String> map = new HashMap<String, String>();
		map.put("account", account);
		map.put("passwd", passwd);
		
		return sqlsession.selectOne("test.finUserByNameAndPsw", map);
	}

	public User findAdminByNameAndPsw(String account, String passwd) {
		SqlSession sqlsession = this.getSqlSession();
		Map<String, String> map = new HashMap<String, String>();
		map.put("account", account);
		map.put("passwd", passwd);
		
		return sqlsession.selectOne("test.findAdminByNameAndPsw", map);
	}

	public List<User> getUserList() {
		SqlSession sqlsession = this.getSqlSession();	
		return sqlsession.selectList("test.getUserList");
	}

	public void updateLoginTime(String account) {
		SqlSession sqlsession = this.getSqlSession();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.m");//设置日期格式
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("account", account);
		map.put("lastLoginTime", df.format(new Date()));
		sqlsession.update("test.updateLoginTime",map);
		
	}

	public User findUserById(String userId) {
		SqlSession sqlsession = this.getSqlSession();
		return sqlsession.selectOne("test.findUserById", userId);
	}

	public void updateUser(User user) {
		SqlSession sqlsession = this.getSqlSession();
		sqlsession.update("test.updateUser", user);
	}

	public List<User> findUser(User user) {
		SqlSession sqlsession = this.getSqlSession();
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("account", "%" + user.getAccount() + "%");
		//System.out.println("email"+ user.getEmail());
		map.put("email", "%" + user.getEmail() + "%");
		
		System.out.println(map);
		//System.out.println();
		 return sqlsession.selectList("test.findUser", map);
	}

	public void deleteUser(String userid) {
		SqlSession sqlsession = this.getSqlSession();
		sqlsession.update("test.deleteUser", userid);
	}

	public List<User> findAllWithFy(int start, int size) throws Exception {
		SqlSession sqlsession = this.getSqlSession();
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("pstart", start);
		map.put("psize", size);
		//System.out.println("email"+ user.getEmail());
		//sqlsession.selectList("test.findAllWithFy", map);
		System.out.println(map);
		return sqlsession.selectList("test.findAllWithFy", map);
	}

	/* (non-Javadoc)
	 * @see com.sise.dao.UserDao#getLong()
	 */
	public int getLong() throws Exception {
		SqlSession sqlsession = this.getSqlSession();
		return sqlsession.selectOne("test.getLong");
	}
	
/*	public static void main(String[] args) throws Exception {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		List<User> findAllWithFy = userDaoImpl.findAllWithFy(0, 3);
		System.out.println(findAllWithFy);
	}*/

}
