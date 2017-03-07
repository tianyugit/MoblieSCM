package com.sise.dao;

import java.util.List;

import com.sise.pojo.Config;



public interface ConfigDao {
	/**
	 * 通过主键删除数据
	 * @param config 主键
	 * @return
	 */
    int deleteByPrimaryKey(String config);

    /**
     * 插入数据
     * @param record 要插入的对象
     * @return
     */
    int insert(Config record);

    /**
     * 可根据数据是否为空动态插入数据
     * @param record 要插入的对象
     * @return
     */
    int insertSelective(Config record);

    /**
     * 获取所有数据
     * @param strings 参数数组
     * @return
     */
	List queryList(String... strings);
}