package com.sise.dao.sup;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sise.pojo.Mobstockin;
import com.sise.pojo.SupMobreturn;

public class MobreturnDaoImpl extends SqlSessionDaoSupport implements MobreturnDao{

	public int deleteByPrimaryKey(String invoiceid) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.delete("mobreturnMapper.deleteByPrimaryKey", invoiceid);
		return 0;
	}

	public int insert(SupMobreturn record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("mobreturnMapper.insert", record);
		return 0;
	}

	public int insertSelective(SupMobreturn record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("mobreturnMapper.insertSelective", record);
		return 0;
	}

	public SupMobreturn selectByPrimaryKey(String invoiceid) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("mobreturnMapper.selectByPrimaryKey", invoiceid);
	}

	public int updateByPrimaryKeySelective(SupMobreturn record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("mobreturnMapper.updateByPrimaryKeySelective", record);
		return 0;
	}

	public int updateByPrimaryKey(SupMobreturn record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("mobreturnMapper.updateByPrimaryKey", record);
		return 0;
	}

	public List<SupMobreturn> queryList(String string) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectList("mobreturnMapper.queryList");
	}
	
	/* (non-Javadoc)
	 * @see com.sise.dao.sup.AccstockDao#getPageLong()
	 */
	public int getPageLong() {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("mobreturnMapper.getPageLong");
	}
	
	public List<SupMobreturn> findAllWithFy(int start, int size) throws Exception {
		SqlSession sqlsession = this.getSqlSession();
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("pstart", start);
		map.put("psize", size);
		//System.out.println("email"+ user.getEmail());
		//sqlsession.selectList("test.findAllWithFy", map);
		System.out.println(map);
		return sqlsession.selectList("mobreturnMapper.findAllWithFy", map);
	}

}
