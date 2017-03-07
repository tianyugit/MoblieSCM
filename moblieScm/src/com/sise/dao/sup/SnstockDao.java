package com.sise.dao.sup;

import java.util.List;
import java.util.Map;

import com.sise.pojo.SnStock;
import com.sise.pojo.SupStockinsn;


public interface SnstockDao {
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
    int insert(SnStock record);

    /**
     * 可根据数据是否为空动态插入数据
     * @param record 要插入的对象
     * @return
     */
    int insertSelective(SnStock record);

    /**
     * 通过主键搜索数据
     * @param invoiceid
     * @return
     */
    SnStock selectByPrimaryKey(String id);

    /**
     * 可根据传入字段是否为空动态更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKeySelective(SnStock record);

    /**
     * 通过主键更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKey(SnStock record);

    /**
     * 通过传入的map插入map中的数据
     * @param snMap
     */
	void insertByMap(Map<String, String> snMap);

	/**
	 * 通过InvoiceId获取SnStockin
	 * @param invoiceid
	 * @return
	 */
	List<SnStock> getSnStockinByInvoiceId(String invoiceid);

	/**
	 * 通过invoiceid删除SN码
	 * @param invoiceid
	 */
	void deleteByInvoiceId(String invoiceid);
}