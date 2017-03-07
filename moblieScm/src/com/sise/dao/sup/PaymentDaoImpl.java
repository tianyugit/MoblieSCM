package com.sise.dao.sup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sise.pojo.Payment;

public class PaymentDaoImpl extends SqlSessionDaoSupport implements PaymentDao{

	public int deleteByPrimaryKey(String invoiceid) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("paymentMapper.deleteByPrimaryKey", invoiceid);
		return 0;
	}

	public int insert(Payment record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("paymentMapper.insert", record);
		
		return 0;
	}

	public int insertSelective(Payment record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("paymentMapper.insertSelective", record);
		return 0;
	}

	public Payment selectByPrimaryKey(String invoiceid) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("paymentMapper.selectByPrimaryKey", invoiceid);
	}

	public int updateByPrimaryKeySelective(Payment record) {
		SqlSession sqlSession = this.getSqlSession();
		
		if(sqlSession.update("paymentMapper.updateByPrimaryKeySelective", record) == 1)
			return 1;
		else
		return 0;
	}

	public int updateByPrimaryKey(Payment record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("paymentMapper.updateByPrimaryKey", record);
		return 0;
	}

	public List<Payment> getList() {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectList("paymentMapper.getList");
	}

	public List<Payment> findPaymentBySupplier(String supplierid) {
		SqlSession sqlSession = this.getSqlSession();
		Map<String,String> map = new HashMap<String,String>();
		map.put("supplierid", supplierid);
		return sqlSession.selectList("paymentMapper.findPaymentBySupplier",map);
	}

}
