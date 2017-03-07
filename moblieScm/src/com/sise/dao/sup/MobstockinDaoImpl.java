package com.sise.dao.sup;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import com.sise.pojo.Mobstockin;

public class MobstockinDaoImpl extends SqlSessionDaoSupport implements MobstockinDao{

	public int deleteByPrimaryKey(String invoiceid) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.delete("supMobstockinMapper.deleteByPrimaryKey", invoiceid);
		return 0;
	}

	public int insert(Mobstockin record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("supMobstockinMapper.insert", record);
		return 0;
	}

	public int insertSelective(Mobstockin record) {
		SqlSession sqlSession = this.getSqlSession();
		System.out.println(record);
		sqlSession.insert("supMobstockinMapper.insertSelective", record);
		return 0;
	}

	public Mobstockin selectByPrimaryKey(String invoiceid) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("supMobstockinMapper.selectByPrimaryKey", invoiceid);
	}

	public int updateByPrimaryKeySelective(Mobstockin record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("supMobstockinMapper.updateByPrimaryKeySelective", record);
		return 0;
	}

	public int updateByPrimaryKey(Mobstockin record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("supMobstockinMapper.updateByPrimaryKey", record);
		return 0;
	}

	public List<Mobstockin> queryList() {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectList("supMobstockinMapper.queryList");
	}

	public List<Mobstockin> findMobStockIn(Map<String, String> map) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectList("supMobstockinMapper.findMobStockIn", map);
	}

	/* (non-Javadoc)
	 * @see com.sise.dao.sup.MobstockinDao#getPageLong()
	 */
	public int getPageLong() {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("supMobstockinMapper.getPageLong");
	}
	
	public List<Mobstockin> findAllWithFy(int start, int size) throws Exception {
		SqlSession sqlsession = this.getSqlSession();
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("pstart", start);
		map.put("psize", size);
		//System.out.println("email"+ user.getEmail());
		//sqlsession.selectList("test.findAllWithFy", map);
		System.out.println(map);
		return sqlsession.selectList("supMobstockinMapper.findAllWithFy", map);
	}
	
}
