package com.sise.dao.cust;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sise.pojo.CustMobsale;
import com.sise.pojo.CustSale;
import com.sise.pojo.JsonBean_data;

public class CustMobsaleDaoImpl extends SqlSessionDaoSupport implements CustMobsaleDao{

	public int deleteByPrimaryKey(String invoiceid) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("custMobsaleMapper.deleteByPrimaryKey", invoiceid);
		return 0;
	}

	public int insert(CustMobsale record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("custMobsaleMapper.insert", record);
		return 0;
	}

	public int insertSelective(CustMobsale record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("custMobsaleMapper.insertSelective", record);
		return 0;
	}

	public CustMobsale selectByPrimaryKey(String invoiceid) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("custMobsaleMapper.selectByPrimaryKey", invoiceid);
	}

	public int updateByPrimaryKeySelective(CustMobsale record) {
		SqlSession sqlSession = this.getSqlSession();
		
		return sqlSession.update("custMobsaleMapper.updateByPrimaryKeySelective", record);
	}

	public int updateByPrimaryKey(CustMobsale record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("custMobsaleMapper.updateByPrimaryKey", record);
		return 0;
	}

	public List<CustMobsale> getList(String string) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectList("custMobsaleMapper.getList");
	}

	public List<JsonBean_data> getSRFormData() {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectList("custMobsaleMapper.getSRFormData");
	}
	
	/* (non-Javadoc)
	 * @see com.sise.dao.sup.AccstockDao#getPageLong()
	 */
	public int getPageLong() {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("custMobsaleMapper.getPageLong");
	}
	

	/* (non-Javadoc)
	 * @see com.sise.dao.sup.SupTradedetailDao#findAllWithFy(java.util.Map, int, int)
	 */
	public List<CustMobsale> findAllWithFy(Map map, int i, int j) {
		SqlSession sqlsession = this.getSqlSession();
		//Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("pstart", i);
		map.put("psize", j);
		//System.out.println("email"+ user.getEmail());
		//sqlsession.selectList("test.findAllWithFy", map);
		System.out.println(map);
		return sqlsession.selectList("custMobsaleMapper.findAllWithFy", map);
	}

}
