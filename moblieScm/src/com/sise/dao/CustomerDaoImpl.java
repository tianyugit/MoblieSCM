package com.sise.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sise.pojo.CustMobsale;
import com.sise.pojo.Customer;
import com.sise.pojo.JsonBean;
import com.sise.pojo.JsonBean_data;

public class CustomerDaoImpl extends SqlSessionDaoSupport implements CustomerDao{

	public int deleteByPrimaryKey(String custid) {
		SqlSession sqlsession = this.getSqlSession();
		sqlsession.delete("customerMapper.deleteByPrimaryKey", custid);
		return 0;
	}

	public int insert(Customer record) {
		SqlSession sqlsession = this.getSqlSession();	
		sqlsession.insert("customerMapper.insert", record);
		return 0;
	}

	public int insertSelective(Customer record) {
		SqlSession sqlsession = this.getSqlSession();	
		sqlsession.insert("customerMapper.insertSelective", record);
		return 0;
	}

	public Customer selectByPrimaryKey(String custid) {
		SqlSession sqlsession = this.getSqlSession();
		return sqlsession.selectOne("customerMapper.selectByPrimaryKey", custid);
	}

	public int updateByPrimaryKeySelective(Customer record) {
		SqlSession sqlsession = this.getSqlSession();
		sqlsession.update("customerMapper.updateByPrimaryKeySelective",record);
		return 0;
	}

	public int updateByPrimaryKey(Customer record) {
		SqlSession sqlsession = this.getSqlSession();
		sqlsession.update("customerMapper.updateByPrimaryKey",record);
		return 0;
	}

	public List<Customer> getCustomerList(String... strings) {
		SqlSession sqlsession = this.getSqlSession();
		String custtypeid = strings[0];
		System.out.println(custtypeid);
		Map<String, String> map = new HashMap<String, String>();
		map.put("custtypeid", custtypeid);
		return sqlsession.selectList("customerMapper.getCustomerList",map);
	}

	public List<Customer> findCustomer(Map<String, String> map) {
		SqlSession sqlsession = this.getSqlSession();
		return sqlsession.selectList("customerMapper.findCustomer",map);
	}

	public List<JsonBean> findCust(Map<String, String> map) {
		SqlSession sqlsession = this.getSqlSession();
		return sqlsession.selectList("customerMapper.findCust",map);
	}

	public Customer findCustByName(String custName) {
		SqlSession sqlsession = this.getSqlSession();
		return sqlsession.selectOne("customerMapper.findCustByName", custName);
	}

	public List<Customer> queryList() {
		SqlSession sqlsession = this.getSqlSession();
		return sqlsession.selectList("customerMapper.queryList");
	}
	
	/* (non-Javadoc)
	 * @see com.sise.dao.sup.AccstockDao#getPageLong()
	 */
	public int getPageLong() {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("customerMapper.getPageLong");
	}
	

	/* (non-Javadoc)
	 * @see com.sise.dao.sup.SupTradedetailDao#findAllWithFy(java.util.Map, int, int)
	 */
	public List<Customer> findAllWithFy(Map map, int i, int j) {
		SqlSession sqlsession = this.getSqlSession();
		//Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("pstart", i);
		map.put("psize", j);
		//System.out.println("email"+ user.getEmail());
		//sqlsession.selectList("test.findAllWithFy", map);
		System.out.println(map);
		return sqlsession.selectList("customerMapper.findAllWithFy", map);
	}



}
