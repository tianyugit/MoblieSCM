/**
 * 
 */
package com.sise.dao.cust;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sise.pojo.CustPayee;

/**========================================================================
 * 
 * 版本:1.0
 *
 *创建日期:2016年12月8日 下午1:25:05
 *
 *作者:马天宇
 *
 *描述:
 *
 *
 *版权:T世界版权所有(c) 2016
 *
 *==========================================================================
 */
public class CustPayeeDaoImpl extends SqlSessionDaoSupport implements CustPayeeDao{

	/* (non-Javadoc)
	 * @see com.sise.dao.cust.CustPayeeDao#deleteByPrimaryKey(java.lang.String)
	 */
	public int deleteByPrimaryKey(String invoiceid) {
		SqlSession sqlsession = this.getSqlSession();
		sqlsession.delete("custPayeeMapper.deleteByPrimaryKey", invoiceid);
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.sise.dao.cust.CustPayeeDao#insert(com.sise.pojo.CustPayee)
	 */
	public int insert(CustPayee record) {
		SqlSession sqlsession = this.getSqlSession();
		sqlsession.insert("custPayeeMapper.insert", record);
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.sise.dao.cust.CustPayeeDao#insertSelective(com.sise.pojo.CustPayee)
	 */
	public int insertSelective(CustPayee record) {
		SqlSession sqlsession = this.getSqlSession();
		sqlsession.insert("custPayeeMapper.insertSelective", record);
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.sise.dao.cust.CustPayeeDao#selectByPrimaryKey(java.lang.String)
	 */
	public CustPayee selectByPrimaryKey(String invoiceid) {
		SqlSession sqlsession = this.getSqlSession();
		return sqlsession.selectOne("custPayeeMapper.selectByPrimaryKey", invoiceid);
	}

	/* (non-Javadoc)
	 * @see com.sise.dao.cust.CustPayeeDao#updateByPrimaryKeySelective(com.sise.pojo.CustPayee)
	 */
	public int updateByPrimaryKeySelective(CustPayee record) {
		SqlSession sqlsession = this.getSqlSession();
		if(sqlsession.insert("custPayeeMapper.updateByPrimaryKeySelective", record) == 1)
			return 1;
		else
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.sise.dao.cust.CustPayeeDao#updateByPrimaryKey(com.sise.pojo.CustPayee)
	 */
	public int updateByPrimaryKey(CustPayee record) {
		SqlSession sqlsession = this.getSqlSession();
		sqlsession.insert("custPayeeMapper.updateByPrimaryKey", record);
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.sise.dao.cust.CustPayeeDao#getList()
	 */
	public List<CustPayee> getList() {
		SqlSession sqlsession = this.getSqlSession();
		return sqlsession.selectList("custPayeeMapper.getList");
	}

	/* (non-Javadoc)
	 * @see com.sise.dao.cust.CustPayeeDao#findPaymentByCust(java.lang.String)
	 */
	public List<CustPayee> findPaymentByCust(String supplierid) {
		SqlSession sqlsession = this.getSqlSession();
		return sqlsession.selectList("custPayeeMapper.findPaymentByCust");
	}

}
