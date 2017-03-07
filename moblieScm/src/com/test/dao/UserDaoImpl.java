package com.test.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.test.pojo.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	public User findUserById(int id) throws Exception {
		SqlSession sqlsession = this.getSqlSession();
		return sqlsession.selectOne("test.findUserById",id);
	}

}
