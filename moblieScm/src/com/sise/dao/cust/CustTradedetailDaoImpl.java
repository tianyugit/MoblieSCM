package com.sise.dao.cust;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sise.pojo.CustTradedetail;
import com.sise.pojo.SupTradedetail;

public class CustTradedetailDaoImpl extends SqlSessionDaoSupport implements CustTradedetailDao{

	public int deleteByPrimaryKey(String invoiceid) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("custTradedetailMapper.deleteByPrimaryKey", invoiceid);
		return 0;
	}

	public int insert(CustTradedetail record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("custTradedetailMapper.insert", record);
		return 0;
	}

	public int insertSelective(CustTradedetail record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("custTradedetailMapper.insertSelective", record);
		return 0;
	}

	public CustTradedetail selectByPrimaryKey(String invoiceid) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("custTradedetailMapper.selectByPrimaryKey", invoiceid);
	}

	public int updateByPrimaryKeySelective(CustTradedetail record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("custTradedetailMapper.updateByPrimaryKeySelective", record);
		return 0;
	}

	public int updateByPrimaryKey(CustTradedetail record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("custTradedetailMapper.updateByPrimaryKey", record);
		return 0;
	}

	public List<CustTradedetail> queryList() {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectList("custTradedetailMapper.queryList");
	}

	/* (non-Javadoc)
	 * @see com.sise.dao.sup.AccstockDao#getPageLong()
	 */
	public int getPageLong() {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("custTradedetailMapper.getPageLong");
	}
	

	/* (non-Javadoc)
	 * @see com.sise.dao.sup.SupTradedetailDao#findAllWithFy(java.util.Map, int, int)
	 */
	public List<CustTradedetail> findAllWithFy(Map map, int i, int j) {
		SqlSession sqlsession = this.getSqlSession();
		//Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("pstart", i);
		map.put("psize", j);
		//System.out.println("email"+ user.getEmail());
		//sqlsession.selectList("test.findAllWithFy", map);
		System.out.println(map);
		return sqlsession.selectList("custTradedetailMapper.findAllWithFy", map);
	}

}
