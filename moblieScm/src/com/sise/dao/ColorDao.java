package com.sise.dao;

import java.util.List;

import com.sise.pojo.Brand;
import com.sise.pojo.Color;

public interface ColorDao {
	/**
	 * 通过主键删除数据
	 * @param color 主键
	 * @return
	 */
    int deleteByPrimaryKey(String color);

    /**
     * 插入数据
     * @param record 要插入的对象
     * @return
     */
    int insert(Color record);

    /**
     * 可根据数据是否为空动态插入数据
     * @param record 要插入的对象
     * @return
     */
    int insertSelective(Color record);
    
    /**
     * 通过主键查找颜色
     * @param color 主键
     * @return
     * @throws Exception
     */
    public Color findColorByPrimaryKey(String color) throws Exception;
    
    /**
     * 获取所有数据
     * @return
     * @throws Exception
     */
    public List queryList() throws Exception;
}