package com.sise.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sise.pojo.SupplierType;

public class SupplierTypeDaoImpl extends SqlSessionDaoSupport implements SupplierTypeDao{

	public int deleteByPrimaryKey(String suptypeid) {
		SqlSession sqlsession = this.getSqlSession();	
		sqlsession.insert("supplierType.deleteByPrimaryKey", suptypeid);
		return 0;
	}

	public int insert(SupplierType record) {
		SqlSession sqlsession = this.getSqlSession();	
		sqlsession.insert("supplierType.insert", record);
		return 1;
	}

	public int insertSelective(SupplierType record) {
		SqlSession sqlsession = this.getSqlSession();	
		sqlsession.insert("supplierType.insertSelective", record);
		return 0;
	}

	public SupplierType selectByPrimaryKey(String suptypeid) {
		SqlSession sqlsession = this.getSqlSession();
		System.out.println(suptypeid);
		return sqlsession.selectOne("supplierType.selectByPrimaryKey", suptypeid);
	}

	public int updateByPrimaryKeySelective(SupplierType record) {
		SqlSession sqlsession = this.getSqlSession();
		sqlsession.insert("supplierType.updateByPrimaryKeySelective", record);
		return 0;
	}

	public int updateByPrimaryKey(SupplierType record) {
		SqlSession sqlsession = this.getSqlSession();
		sqlsession.update("supplierType.updateByPrimaryKey",record);
		return 0;
	}

	public List<SupplierType> getTypeList() {
		SqlSession sqlsession = this.getSqlSession();
		return sqlsession.selectList("supplierType.getTypeList");
	}

}
