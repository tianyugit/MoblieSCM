package com.sise.dao.sup;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sise.pojo.SnStock;

public class SnstockDaoImpl extends SqlSessionDaoSupport implements SnstockDao{

	public int deleteByPrimaryKey(String id) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.delete("snstockMapper.deleteByPrimaryKey", id);
		return 0;
	}

	public int insert(SnStock record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("snstockMapper.insert", record);
		return 0;
	}

	public int insertSelective(SnStock record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("snstockMapper.insertSelective", record);
		return 0;
	}

	public SnStock selectByPrimaryKey(String id) {
		SqlSession sqlSession = this.getSqlSession();
		
		return sqlSession.selectOne("snstockMapper.selectByPrimaryKey", id);
	}

	public int updateByPrimaryKeySelective(SnStock record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("snstockMapper.updateByPrimaryKeySelective", record);
		return 0;
	}

	public int updateByPrimaryKey(SnStock record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("snstockMapper.updateByPrimaryKey", record);
		return 0;
	}

	public void insertByMap(Map<String, String> snMap) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("snstockMapper.insertByMap", snMap);
		
	}

	public List<SnStock> getSnStockinByInvoiceId(String invoiceid) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectList("snstockMapper.getSnStockinByInvoiceId", invoiceid);
	}

	public void deleteByInvoiceId(String invoiceid) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("snstockMapper.deleteByInvoiceId", invoiceid);
	}

}
