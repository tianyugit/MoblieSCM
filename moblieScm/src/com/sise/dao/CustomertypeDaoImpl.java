package com.sise.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sise.pojo.Customertype;

public class CustomertypeDaoImpl extends SqlSessionDaoSupport implements CustomertypeDao{

	public int deleteByPrimaryKey(String custtypeid) {
		SqlSession sqlsession = this.getSqlSession();	
		sqlsession.delete("customertypeMapper.deleteByPrimaryKey", custtypeid);
		return 0;
	}

	public int insert(Customertype record) {
		SqlSession sqlsession = this.getSqlSession();	
		sqlsession.insert("customertypeMapper.insert", record);
		return 1;
	}

	public int insertSelective(Customertype record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Customertype selectByPrimaryKey(String custtypeid) {
		SqlSession sqlsession = this.getSqlSession();
		System.out.println(custtypeid);
		return sqlsession.selectOne("customertypeMapper.selectByPrimaryKey", custtypeid);
	}

	public int updateByPrimaryKeySelective(Customertype record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(Customertype record) {
		SqlSession sqlsession = this.getSqlSession();
		sqlsession.update("customertypeMapper.updateByPrimaryKey",record);
		return 0;
	}
	
	public List<Customertype> getTypeList() {
		SqlSession sqlsession = this.getSqlSession();
		
		return sqlsession.selectList("customertypeMapper.getTypeList");
	}

}
