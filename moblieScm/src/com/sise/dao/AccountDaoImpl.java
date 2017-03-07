package com.sise.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sise.pojo.Account;

public class AccountDaoImpl extends SqlSessionDaoSupport implements AccountDao{

	public int deleteByPrimaryKey(String accountid) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("accountMapper.deleteByPrimaryKey", accountid);
		return 0;
	}

	public int insert(Account record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("accountMapper.insert", record);
		return 0;
	}

	public int insertSelective(Account record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("accountMapper.insertSelective", record);
		return 0;
	}

	public Account selectByPrimaryKey(String accountid) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("accountMapper.selectByPrimaryKey", accountid);
	}

	public int updateByPrimaryKeySelective(Account record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("accountMapper.updateByPrimaryKeySelective", record);
		return 0;
	}

	public int updateByPrimaryKey(Account record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("accountMapper.updateByPrimaryKey", record);
		return 0;
	}

	public List<Account> getList() {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectList("accountMapper.getList");
	}

}
