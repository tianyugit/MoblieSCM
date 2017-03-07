package com.sise.dao;

import java.util.List;

import com.sise.pojo.SupplierType;


public interface SupplierTypeDao {
	/**
	 * 通过主键删除数据
	 * @param suptypeid 主键
	 * @return
	 */
    int deleteByPrimaryKey(String suptypeid);

    /**
     * 插入数据
     * @param record 要插入的对象
     * @return
     */
    int insert(SupplierType record);

    /**
     * 可根据数据是否为空动态插入数据
     * @param record 要插入的对象
     * @return
     */
    int insertSelective(SupplierType record);

    /**
     * 通过主键搜索数据
     * @param invoiceid
     * @return
     */
    SupplierType selectByPrimaryKey(String suptypeid);

    /**
     * 可根据传入字段是否为空动态更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKeySelective(SupplierType record);

    /**
     * 通过主键更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKey(SupplierType record);

    /**
     * 获取所有数据
     * @return
     */
	List<SupplierType> getTypeList();
}