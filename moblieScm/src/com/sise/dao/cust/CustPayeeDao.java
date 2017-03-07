package com.sise.dao.cust;

import java.util.List;

import com.sise.pojo.CustPayee;

public interface CustPayeeDao {
    int deleteByPrimaryKey(String invoiceid);

    int insert(CustPayee record);

    int insertSelective(CustPayee record);

    CustPayee selectByPrimaryKey(String invoiceid);

    int updateByPrimaryKeySelective(CustPayee record);

    int updateByPrimaryKey(CustPayee record);

	/**
	 * @return
	 */
	List<CustPayee> getList();

	/**
	 * @param supplierid
	 * @return
	 */
	List<CustPayee> findPaymentByCust(String supplierid);
}