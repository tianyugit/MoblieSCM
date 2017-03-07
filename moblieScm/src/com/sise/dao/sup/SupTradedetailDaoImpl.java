package com.sise.dao.sup;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sise.pojo.Mobstockin;
import com.sise.pojo.SupTradedetail;

public class SupTradedetailDaoImpl extends SqlSessionDaoSupport implements SupTradedetailDao{

	public int deleteByPrimaryKey(String invoiceid) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("supTradedetailMapper.deleteByPrimaryKey", invoiceid);
		return 0;
	}

	public int insert(SupTradedetail record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("supTradedetailMapper.insert", record);
		return 0;
	}

	public int insertSelective(SupTradedetail record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("supTradedetailMapper.insertSelective", record);
		return 0;
	}

	public SupTradedetail selectByPrimaryKey(String invoiceid) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("supTradedetailMapper.selectByPrimaryKey", invoiceid);
	}

	public int updateByPrimaryKeySelective(SupTradedetail record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("supTradedetailMapper.updateByPrimaryKeySelective", record);
		return 0;
	}

	public int updateByPrimaryKey(SupTradedetail record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("supTradedetailMapper.updateByPrimaryKey", record);
		return 0;
	}

	public List<SupTradedetail> queryList() {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectList("supTradedetailMapper.queryList");
	}

	/* (non-Javadoc)
	 * @see com.sise.dao.sup.SupTradedetailDao#findTDlBySelected(java.util.Map)
	 */
	public List<SupTradedetail> findTDlBySelected(Map<String, String> map) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectList("supTradedetailMapper.findTDlBySelected", map);
	}

	/* (non-Javadoc)
	 * @see com.sise.dao.sup.SupTradedetailDao#queryListLimitDate(java.util.Map)
	 */
	public List<SupTradedetail> queryListLimitDate(Map map) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectList("supTradedetailMapper.queryListLimitDate", map);
	}
	
	/* (non-Javadoc)
	 * @see com.sise.dao.sup.AccstockDao#getPageLong()
	 */
	public int getPageLong() {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("supTradedetailMapper.getPageLong");
	}
	

	/* (non-Javadoc)
	 * @see com.sise.dao.sup.SupTradedetailDao#findAllWithFy(java.util.Map, int, int)
	 */
	public List<SupTradedetail> findAllWithFy(Map map, int i, int j) {
		SqlSession sqlsession = this.getSqlSession();
		//Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("pstart", i);
		map.put("psize", j);
		//System.out.println("email"+ user.getEmail());
		//sqlsession.selectList("test.findAllWithFy", map);
		System.out.println(map);
		return sqlsession.selectList("supTradedetailMapper.findAllWithFy", map);
	}

}
