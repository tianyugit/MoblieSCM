package com.sise.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sise.pojo.Supplier;

public class SupplierDaoImpl extends SqlSessionDaoSupport implements SupplierDao{

	public int deleteByPrimaryKey(String supid) {
		SqlSession sqlsession = this.getSqlSession();
		sqlsession.delete("supplier.deleteByPrimaryKey", supid);
		return 0;
	}

	public int insert(Supplier record) {
		SqlSession sqlsession = this.getSqlSession();	
		sqlsession.insert("supplier.insert", record);
		return 0;
	}

	public int insertSelective(Supplier record) {
		SqlSession sqlsession = this.getSqlSession();	
		sqlsession.insert("supplier.insertSelective", record);
		return 0;
	}

	public Supplier selectByPrimaryKey(String supid) {
		SqlSession sqlsession = this.getSqlSession();
		
		return sqlsession.selectOne("supplier.selectByPrimaryKey", supid);
	}

	public int updateByPrimaryKeySelective(Supplier record) {
		SqlSession sqlsession = this.getSqlSession();
		sqlsession.update("supplier.updateByPrimaryKeySelective",record);
		return 0;
	}

	public int updateByPrimaryKey(Supplier record) {
		SqlSession sqlsession = this.getSqlSession();
		sqlsession.update("supplier.updateByPrimaryKey",record);
		return 0;
	}

	public List<Supplier> getSupplierList(String... strings) {
		SqlSession sqlsession = this.getSqlSession();
		String stypeid = strings[0];
		System.out.println(stypeid);
		Map<String, String> map = new HashMap<String, String>();
		map.put("stypeid", stypeid);
		return sqlsession.selectList("supplier.getSupplierList",map);
	}

	public List<Supplier> findSupplier(Map<String, String> map) {
		SqlSession sqlsession = this.getSqlSession();
		
		return sqlsession.selectList("supplier.findSupplier",map);
	}

	public List<Supplier> findSupplierAjax(Map<String, String> map) {
		SqlSession sqlsession = this.getSqlSession();
		return sqlsession.selectList("supplier.findSupplierAjax",map);
	}

	public List getSupplierList2(String suptypeid) {
		SqlSession sqlsession = this.getSqlSession();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("stypeid", suptypeid);
		return sqlsession.selectList("supplier.getSupplierList2",map);
	}

}
