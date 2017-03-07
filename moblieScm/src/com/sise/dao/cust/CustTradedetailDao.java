package com.sise.dao.cust;

import java.util.List;
import java.util.Map;

import com.sise.pojo.CustTradedetail;
import com.sise.pojo.SupTradedetail;

public interface CustTradedetailDao {
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
    int insert(CustTradedetail record);

    /**
     * 可根据数据是否为空动态插入数据
     * @param record 要插入的对象
     * @return
     */
    int insertSelective(CustTradedetail record);

    /**
     * 通过主键搜索数据
     * @param invoiceid
     * @return
     */
    CustTradedetail selectByPrimaryKey(String invoiceid);

    /**
     * 可根据传入字段是否为空动态更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKeySelective(CustTradedetail record);

    /**
     * 通过主键更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKey(CustTradedetail record);

    /**
     * 查找所有数据
     * @return
     */
	List<CustTradedetail> queryList();
	
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
	List<CustTradedetail> findAllWithFy(Map map, int i, int j);
}