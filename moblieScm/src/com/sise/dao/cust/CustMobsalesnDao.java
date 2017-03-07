package com.sise.dao.cust;

import java.util.List;
import java.util.Map;

import com.sise.pojo.CustMobsale;
import com.sise.pojo.CustMobsalesn;

public interface CustMobsalesnDao {
	/**
	 * 通过主键删除数据
	 * @param id 主键
	 * @return
	 */
    int deleteByPrimaryKey(String id);

    /**
     * 插入数据
     * @param record 要插入的对象
     * @return
     */
    int insert(CustMobsalesn record);

    /**
     * 可根据数据是否为空动态插入数据
     * @param record 要插入的对象
     * @return
     */
    int insertSelective(CustMobsalesn record);

    /**
     * 通过主键搜索数据
     * @param invoiceid
     * @return
     */
    CustMobsalesn selectByPrimaryKey(String id);

    /**
     * 可根据传入字段是否为空动态更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKeySelective(CustMobsalesn record);

    /**
     * 通过主键更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKey(CustMobsalesn record);

    /**
     * 通过传入的map插入map中的数据
     * @param snMap
     */
	void insertByMap(Map<String, String> snMap);

	/**
	 * 通过单号获取串号
	 * @param mobSale
	 * @return
	 */
	List<CustMobsalesn> getSnByInvoiceid(CustMobsale mobSale);
}