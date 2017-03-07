package com.sise.dao;

import java.util.List;
import java.util.Map;

import com.sise.pojo.Accessorytype;


public interface AccessorytypeDao {
	/**
	 * 通过主键删除数据
	 * @param accessorytypeid 主键
	 * @return
	 */
    int deleteByPrimaryKey(String accessorytypeid);

    /**
     * 插入数据
     * @param record 要插入的对象
     * @return
     */
    int insert(Accessorytype record);

    /**
     * 可根据数据是否为空动态插入数据
     * @param record 要插入的对象
     * @return
     */
    int insertSelective(Accessorytype record);

    /**
     * 通过主键搜索数据
     * @param invoiceid
     * @return
     */
    Accessorytype selectByPrimaryKey(String accessorytypeid);

    /**
     * 可根据传入字段是否为空动态更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKeySelective(Accessorytype record);

    /**
     * 通过主键更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKey(Accessorytype record);

    /**
     * 获取所有数据
     * @return
     */
	List<Accessorytype> getTypeList();

	/**
	 * 通过map查找AccessoryType
	 * @param map
	 * @return
	 */
	List<Accessorytype> findAccessoryType(Map<String, String> map);

	/**
	 * 通过品牌查找AccType
	 * @param brand
	 * @return
	 */
	List<Accessorytype> findAccTypeByBrand(String brand);

	List<Accessorytype> findaccTypeByselected(Map<String, String> map);
}