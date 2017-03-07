package com.sise.dao;

import java.util.List;
import java.util.Map;

import com.sise.pojo.Mobtype;


public interface MobtypeDao {
	/**
	 * 通过主键删除数据
	 * @param mobtypeid 主键
	 * @return
	 */
    int deleteByPrimaryKey(String mobtypeid);

    /**
     * 插入数据
     * @param record 要插入的对象
     * @return
     */
    int insert(Mobtype record);

    /**
     * 可根据数据是否为空动态插入数据
     * @param record 要插入的对象
     * @return
     */
    int insertSelective(Mobtype record);

    /**
     * 通过主键搜索数据
     * @param mobtypeid
     * @return
     */
    Mobtype selectByPrimaryKey(String mobtypeid);

    /**
     * 可根据传入字段是否为空动态更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKeySelective(Mobtype record);

    /**
     * 通过主键更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKey(Mobtype record);
    
    /**
     * 获取所有数据
     * @param strings 参数数组
     * @return
     */
    public List queryList(String... strings);

    /**
     * 通过品牌查找手机类别
     * @param brand
     * @return
     */
	List<Mobtype> findMobTypeByBrand(String brand);

	/**
	 * @param map
	 * @return
	 */
	List findMobtypeBySelected(Map<String, String> map);
}