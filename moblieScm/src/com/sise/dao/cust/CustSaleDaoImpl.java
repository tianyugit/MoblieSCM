package com.sise.dao.cust;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sise.pojo.CustSale;
import com.sise.pojo.CustTradedetail;

public class CustSaleDaoImpl extends SqlSessionDaoSupport implements CustSaleDao {

	public int deleteByPrimaryKey(String invoiceid) {
		SqlSession sqlsession = this.getSqlSession();
		sqlsession.update("custSaleMapper.deleteByPrimaryKey",invoiceid);
		return 0;
	}

	public int insert(CustSale record) {
		SqlSession sqlsession = this.getSqlSession();
		sqlsession.update("custSaleMapper.insert",record);
		return 0;
	}

	public int insertSelective(CustSale record) {
		SqlSession sqlsession = this.getSqlSession();
		sqlsession.update("custSaleMapper.insertSelective",record);
		return 0;
	}

	public CustSale selectByPrimaryKey(String invoiceid) {
		SqlSession sqlsession = this.getSqlSession();
		return sqlsession.selectOne("custSaleMapper.selectByPrimaryKey", invoiceid);
	}

	public int updateByPrimaryKeySelective(CustSale record) {
		SqlSession sqlsession = this.getSqlSession();
		sqlsession.update("custSaleMapper.updateByPrimaryKeySelective",record);
		return 0;
	}

	public int updateByPrimaryKey(CustSale record) {
		SqlSession sqlsession = this.getSqlSession();
		sqlsession.update("custSaleMapper.updateByPrimaryKey",record);
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.sise.dao.sup.AccstockDao#getPageLong()
	 */
	public int getPageLong() {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("custSaleMapper.getPageLong");
	}
	

	/* (non-Javadoc)
	 * @see com.sise.dao.sup.SupTradedetailDao#findAllWithFy(java.util.Map, int, int)
	 */
	public List<CustSale> findAllWithFy(Map map, int i, int j) {
		SqlSession sqlsession = this.getSqlSession();
		//Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("pstart", i);
		map.put("psize", j);
		//System.out.println("email"+ user.getEmail());
		//sqlsession.selectList("test.findAllWithFy", map);
		System.out.println(map);
		return sqlsession.selectList("custSaleMapper.findAllWithFy", map);
	}
}
