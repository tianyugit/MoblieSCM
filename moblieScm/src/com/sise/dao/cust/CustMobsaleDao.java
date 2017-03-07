package com.sise.dao.cust;

import java.util.List;
import java.util.Map;

import com.sise.pojo.CustMobsale;
import com.sise.pojo.CustSale;
import com.sise.pojo.JsonBean_data;

public interface CustMobsaleDao {
	/**
	 * 通过主键删除数据
	 * @param invoiceid 主键
	 * @return
	 */
    int deleteByPrimaryKey(String invoiceid);

    /**
     * 插入数据
     * @param record 要插入的对象
     * @return
     */
    int insert(CustMobsale record);

    /**
     * 可根据数据是否为空动态插入数据
     * @param record 要插入的对象
     * @return
     */
    int insertSelective(CustMobsale record);

    /**
     * 通过主键搜索数据
     * @param invoiceid
     * @return
     */
    CustMobsale selectByPrimaryKey(String invoiceid);

    /**
     * 可根据传入字段是否为空动态更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKeySelective(CustMobsale record);

    /**
     * 通过主键更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKey(CustMobsale record);

    /**
     * 获取所有数据
     * @param string
     * @return
     */
	List<CustMobsale> getList(String string);

	/**
	 * 获取报表数据
	 * @return
	 */
	List<JsonBean_data> getSRFormData();
	
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
	List<CustMobsale> findAllWithFy(Map map, int i, int j);
}