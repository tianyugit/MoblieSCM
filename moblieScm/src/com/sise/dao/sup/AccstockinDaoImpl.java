package com.sise.dao.sup;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sise.pojo.Accstockin;
import com.sise.pojo.Mobstockin;

public class AccstockinDaoImpl extends SqlSessionDaoSupport implements AccstockinDao{

	public int deleteByPrimaryKey(String invoiceid) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("accstockinMapper.deleteByPrimaryKey", invoiceid);
		return 0;
	}

	public int insert(Accstockin record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("accstockinMapper.insert", record);
		return 0;
	}

	public int insertSelective(Accstockin record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("accstockinMapper.insertSelective", record);
		return 0;
	}

	public Accstockin selectByPrimaryKey(String invoiceid) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("accstockinMapper.selectByPrimaryKey", invoiceid);
	}

	public int updateByPrimaryKeySelective(Accstockin record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("accstockinMapper.updateByPrimaryKeySelective", record);
		return 0;
	}

	public int updateByPrimaryKey(Accstockin record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("accstockinMapper.updateByPrimaryKey", record);
		return 0;
	}

	public List<Accstockin> getList() {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectList("accstockinMapper.getList");
	}

	public List<Accstockin> getaccTypeByMap(Map<String, String> map) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectList("accstockinMapper.getaccTypeByMap", map);
	}
	
	/* (non-Javadoc)
	 * @see com.sise.dao.sup.AccstockDao#getPageLong()
	 */
	public int getPageLong() {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("accstockinMapper.getPageLong");
	}
	
	public List<Accstockin> findAllWithFy(int start, int size) throws Exception {
		SqlSession sqlsession = this.getSqlSession();
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("pstart", start);
		map.put("psize", size);
		//System.out.println("email"+ user.getEmail());
		//sqlsession.selectList("test.findAllWithFy", map);
		System.out.println(map);
		return sqlsession.selectList("accstockinMapper.findAllWithFy", map);
	}

}
