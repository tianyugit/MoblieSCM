package com.sise.dao.cust;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sise.pojo.CustMobsale;
import com.sise.pojo.CustMobsalesn;

public class CustMobsalesnDaoImpl extends SqlSessionDaoSupport implements CustMobsalesnDao{

	public int deleteByPrimaryKey(String id) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("custMobsalesnMapper.deleteByPrimaryKey", id);
		return 0;
	}

	public int insert(CustMobsalesn record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("custMobsalesnMapper.insert", record);
		return 0;
	}

	public int insertSelective(CustMobsalesn record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("custMobsalesnMapper.insertSelective", record);
		return 0;
	}

	public CustMobsalesn selectByPrimaryKey(String id) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("custMobsalesnMapper.selectByPrimaryKey", id);
	}

	public int updateByPrimaryKeySelective(CustMobsalesn record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("custMobsalesnMapper.updateByPrimaryKeySelective", record);
		return 0;
	}

	public int updateByPrimaryKey(CustMobsalesn record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("custMobsalesnMapper.updateByPrimaryKey", record);
		return 0;
	}

	public void insertByMap(Map<String, String> snMap) {
		SqlSession sqlSesion = this.getSqlSession();
		sqlSesion.insert("custMobsalesnMapper.insertByMap", snMap);
		
	}

	public List<CustMobsalesn> getSnByInvoiceid(CustMobsale mobSale) {
		SqlSession sqlSesion = this.getSqlSession();
		String invoiceid = mobSale.getInvoiceid();
		return sqlSesion.selectList("custMobsalesnMapper.getSnByInvoiceid", invoiceid);
	}

}
