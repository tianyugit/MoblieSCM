package com.sise.dao.cust;

import java.util.List;
import java.util.Map;

import com.sise.pojo.CustSale;

public interface CustSaleDao {
    int deleteByPrimaryKey(String invoiceid);

    int insert(CustSale record);

    int insertSelective(CustSale record);

    CustSale selectByPrimaryKey(String invoiceid);

    int updateByPrimaryKeySelective(CustSale record);

    int updateByPrimaryKey(CustSale record);
    
    /**
	 * 获取分页总长度
	 * @return
	 */
	int getPageLong();

	/**
	 * @param map
	 * @param i
	 * @param j
	 * @return
	 */
	List<CustSale> findAllWithFy(Map map, int i, int j);
}