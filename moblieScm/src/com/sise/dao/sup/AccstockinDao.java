package com.sise.dao.sup;

import java.util.List;
import java.util.Map;

import com.sise.pojo.Accstockin;
import com.sise.pojo.Mobstockin;


public interface AccstockinDao {
	/**
	 * 通过主键删除数据
	 * @param invoiceid 主键
	 * @return
	 */
    int deleteByPrimaryKey(String invoiceid);
    
    /**
     * 插入数据
     * @param record 要插入的对象
     * @return
     */
    int insert(Accstockin record);
    
    /**
     * 可根据数据是否为空动态插入数据
     * @param record 要插入的对象
     * @return
     */
    int insertSelective(Accstockin record);
    
    /**
     * 通过主键搜索数据
     * @param invoiceid
     * @return
     */
    Accstockin selectByPrimaryKey(String invoiceid);
    
    /**
     * 可根据传入字段是否为空动态更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKeySelective(Accstockin record);
    
    /**
     * 更加主键更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKey(Accstockin record);
    
    /**
     * 获取Accstockin表的所有数据
     * @return
     */
	List<Accstockin> getList();

	/**
	 * 通过品牌和配件机型获取配件
	 * @param map
	 * @return
	 */
	List<Accstockin> getaccTypeByMap(Map<String, String> map);
	
	/**
	 * 获取分页总长度
	 * @return
	 */
	int getPageLong();
	/**
	 * 查询分页数据
	 * @param start
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public List<Accstockin> findAllWithFy(int start, int size) throws Exception;
}