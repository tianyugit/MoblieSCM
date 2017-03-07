package com.sise.dao.sup;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sise.pojo.AccStock;
import com.sise.pojo.Mobstockin;
import com.sise.pojo.StoCount;

public class AccstockDaoImpl extends SqlSessionDaoSupport implements AccstockDao{

	public int deleteByPrimaryKey(String sn) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.delete("accstockMapper.deleteByPrimaryKey", sn);
		return 0;
	}

	public int insert(AccStock record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("accstockMapper.insert", record);
		return 0;
	}

	public int insertSelective(AccStock record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("accstockMapper.insert", record);
		return 0;
	}

	public AccStock selectByPrimaryKey(String sn) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("accstockMapper.selectByPrimaryKey", sn);
	}

	public int updateByPrimaryKeySelective(AccStock record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("accstockMapper.updateByPrimaryKeySelective", record);
		return 0;
	}

	public int updateByPrimaryKey(AccStock record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("accstockMapper.updateByPrimaryKeySelective", record);
		return 0;
	}

	public List<StoCount> countAccType() {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectList("accstockMapper.countAccType");
	}

	public List<AccStock> findmobStockByaccTypeId(String accessorytypeid) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectList("accstockMapper.findmobStockByaccTypeId",accessorytypeid);
	}

	/* (non-Javadoc)
	 * @see com.sise.dao.sup.AccstockDao#getPageLong()
	 */
	public int getPageLong() {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("accstockMapper.getPageLong");
	}
	
	public List<Mobstockin> findAllWithFy(int start, int size) throws Exception {
		SqlSession sqlsession = this.getSqlSession();
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("pstart", start);
		map.put("psize", size);
		//System.out.println("email"+ user.getEmail());
		//sqlsession.selectList("test.findAllWithFy", map);
		System.out.println(map);
		return sqlsession.selectList("accstockMapper.findAllWithFy", map);
	}

}
