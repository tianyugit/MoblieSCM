package com.sise.dao.sup;

import java.util.List;

import com.sise.pojo.AccStock;
import com.sise.pojo.Mobstockin;
import com.sise.pojo.StoCount;


public interface AccstockDao {
	/**
	 * 通过主键删除数据
	 * @param sn 主键
	 * @return
	 */
    int deleteByPrimaryKey(String sn);
    /**
     * 插入数据
     * @param record 要插入的对象
     * @return
     */
    int insert(AccStock record);
    /**
     * 可根据数据是否为空动态插入数据
     * @param record 要插入的对象
     * @return
     */
    int insertSelective(AccStock record);
    /**
     * 通过主键搜索数据
     * @param sn
     * @return
     */
    AccStock selectByPrimaryKey(String sn);
    /**
     * 可根据传入字段是否为空动态更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKeySelective(AccStock record);
    /**
     * 更加主键更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKey(AccStock record);
    /**
     * 计算类型个数
     * @return 计算结果填充到StoCount对象中
     */
	List<StoCount> countAccType();
	/**
	 * 通过accTypeId查找mobStock
	 * @param accessorytypeid
	 * @return
	 */
	List<AccStock> findmobStockByaccTypeId(String accessorytypeid);
	
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
	public List<Mobstockin> findAllWithFy(int start, int size) throws Exception;
}