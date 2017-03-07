package com.sise.dao.sup;

import java.util.List;

import com.sise.pojo.JsonBean_data;
import com.sise.pojo.Mobstock;
import com.sise.pojo.StoCount;

public interface MobstockDao {
	/**
	 * 通过主键删除数据
	 * @param sn1 主键
	 * @return
	 */
    int deleteByPrimaryKey(String sn1);

    /**
     * 插入数据
     * @param record 要插入的对象
     * @return
     */
    int insert(Mobstock record);

    /**
     * 可根据数据是否为空动态插入数据
     * @param record 要插入的对象
     * @return
     */
    int insertSelective(Mobstock record);

    /**
     * 通过主键搜索数据
     * @param invoiceid
     * @return
     */
    Mobstock selectByPrimaryKey(String sn1);

    /**
     * 可根据传入字段是否为空动态更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKeySelective(Mobstock record);

    /**
     * 通过主键更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKey(Mobstock record);

    /**
     *通过sn2更新数据
     * @param record 要更新的对象
     * @return
     */
	Mobstock selectByPrimaryKey2(String sn2);

	/**
	 * 计算Mobtype数量
	 * @return
	 */
	List<StoCount> countMobtype();

	/**
	 * 通过mobTypeId查找mobStock
	 * @param mobtypeid
	 * @return
	 */
	List<Mobstock> findmobStockBymobTypeId(String mobtypeid);

	/**
	 * 获取报表数据
	 * @return
	 */
	List<JsonBean_data> getSRFormData();

	/*List<Mobstock> findmobStockByInvoiceId(String invoiceid);*/

}