package com.sise.dao;

import java.util.List;
import java.util.Map;

import com.sise.pojo.Supplier;

public interface SupplierDao {
	/**
	 * 通过主键删除数据
	 * @param supid 主键
	 * @return
	 */
    int deleteByPrimaryKey(String supid);

    /**
     * 插入数据
     * @param record 要插入的对象
     * @return
     */
    int insert(Supplier record);

    /**
     * 可根据数据是否为空动态插入数据
     * @param record 要插入的对象
     * @return
     */
    int insertSelective(Supplier record);

    /**
     * 通过主键搜索数据
     * @param supid
     * @return
     */
    Supplier selectByPrimaryKey(String supid);

    /**
     * 可根据传入字段是否为空动态更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKeySelective(Supplier record);

    /**
     * 通过主键更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKey(Supplier record);

    /**
     * 获取所有数据
     * @param strings 参数数组
     * @return
     */
	List<Supplier> getSupplierList(String... strings);

	/**
	 * 查找供应商
	 * @param map
	 * @return
	 */
	List<Supplier> findSupplier(Map<String, String> map);

	/**
	 * 通过ajax查找供应商
	 * @param map
	 * @return
	 */
	List<Supplier> findSupplierAjax(Map<String, String> map);

	List getSupplierList2(String suptypeid);
}