package com.sise.dao.sup;

import java.util.List;
import java.util.Map;

import com.sise.pojo.SupMobreturn;
import com.sise.pojo.SupMobstocksnout;
import com.sise.pojo.SupStockinsn;

public interface MobstocksnoutDao {
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
    int insert(SupMobstocksnout record);

    /**
     * 可根据数据是否为空动态插入数据
     * @param record 要插入的对象
     * @return
     */
    int insertSelective(SupMobstocksnout record);

    /**
     * 通过主键搜索数据
     * @param invoiceid
     * @return
     */
    SupMobstocksnout selectByPrimaryKey(String id);

    /**
     * 可根据传入字段是否为空动态更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKeySelective(SupMobstocksnout record);

    /**
     * 通过主键更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKey(SupMobstocksnout record);

    /**
     * 通过传入的map插入map中的数据
     * @param snMap
     */
	void insertByMap(Map<String, String> snMap);

	/**
	 * 通过Invoiceid找到sn
	 * @param mobreturn
	 * @return
	 */
	List<SupMobstocksnout> getSnByInvoiceid(SupMobreturn mobreturn);


}