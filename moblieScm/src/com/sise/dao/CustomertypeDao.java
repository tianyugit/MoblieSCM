package com.sise.dao;

import java.util.List;

import com.sise.pojo.Customertype;


public interface CustomertypeDao {
	/**
	 * 通过主键删除数据
	 * @param custtypeid 主键
	 * @return
	 */
    int deleteByPrimaryKey(String custtypeid);

    /**
     * 插入数据
     * @param record 要插入的对象
     * @return
     */
    int insert(Customertype record);

    /**
     * 可根据数据是否为空动态插入数据
     * @param record 要插入的对象
     * @return
     */
    int insertSelective(Customertype record);

    /**
     * 通过主键搜索数据
     * @param custtypeid
     * @return
     */
    Customertype selectByPrimaryKey(String custtypeid);

    /**
     * 可根据传入字段是否为空动态更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKeySelective(Customertype record);

    /**
     * 通过主键更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKey(Customertype record);

    /**
     * 获取所有数据
     * @return
     */
	List<Customertype> getTypeList();
}