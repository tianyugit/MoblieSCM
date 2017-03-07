package com.sise.dao;

import java.util.List;

import com.sise.pojo.Brand;

@SuppressWarnings({ "rawtypes" })
public interface BrandDao {
	/**
	 * 通过主键删除数据
	 * @param brand 主键
	 * @return
	 */
    int deleteByPrimaryKey(String brand);

    /**
     * 插入数据
     * @param record 要插入的对象
     * @return
     */
    int insert(Brand record);

    /**
     * 可根据数据是否为空动态插入数据
     * @param record 要插入的对象
     * @return
     */
    int insertSelective(Brand record);
    
    /**
     * 通过主键找到品牌
     * @param brand
     * @return
     * @throws Exception
     */
    public Brand findBrandByPrimaryKey(String brand) throws Exception;
    
    /**
     * 获取所有数据
     * @return
     * @throws Exception
     */
    public List queryList() throws Exception;
}