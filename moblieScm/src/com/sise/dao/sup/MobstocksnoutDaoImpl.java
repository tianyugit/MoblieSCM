package com.sise.dao.sup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sise.pojo.SupMobreturn;
import com.sise.pojo.SupMobstocksnout;
import com.sise.pojo.SupStockinsn;

public class MobstocksnoutDaoImpl extends SqlSessionDaoSupport implements MobstocksnoutDao{

	public int deleteByPrimaryKey(String id) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.delete("mobstocksnoutMapper.deleteByPrimaryKey", id);
		return 0;
	}

	public int insert(SupMobstocksnout record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("mobstocksnoutMapper.insert", record);
		return 0;
	}

	public int insertSelective(SupMobstocksnout record) {
		SqlSession sqlSession = this.getSqlSession();
		System.out.println(record);
		sqlSession.insert("mobstocksnoutMapper.insertSelective", record);
		return 0;
	}

	public SupMobstocksnout selectByPrimaryKey(String id) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("mobstocksnoutMapper.selectByPrimaryKey", id);
	}

	public int updateByPrimaryKeySelective(SupMobstocksnout record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("mobstocksnoutMapper.updateByPrimaryKeySelective", record);
		return 0;
	}

	public int updateByPrimaryKey(SupMobstocksnout record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("mobstocksnoutMapper.updateByPrimaryKey", record);
		return 0;
	}

	public void insertByMap(Map<String, String> snMap) {
		SqlSession sqlSesion = this.getSqlSession();
		sqlSesion.insert("mobstocksnoutMapper.insertByMap", snMap);
		
	}

	public List<SupMobstocksnout> getSnByInvoiceid(SupMobreturn mobreturn) {
		SqlSession sqlSesion = this.getSqlSession();
		Map<String,String> map = new HashMap<String, String>();
		map.put("invoiceid", mobreturn.getInvoiceid());
		return sqlSesion.selectList("mobstocksnoutMapper.getSnByInvoiceid", map);
	}

}
