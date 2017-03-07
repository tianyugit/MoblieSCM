package com.sise.dao.sup;

import java.util.List;
import java.util.Map;

import com.sise.pojo.Mobstockin;
import com.sise.pojo.User;


public interface MobstockinDao {
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
    int insert(Mobstockin record);

    /**
     * 可根据数据是否为空动态插入数据
     * @param record 要插入的对象
     * @return
     */
    int insertSelective(Mobstockin record);

    /**
     * 通过主键搜索数据
     * @param invoiceid
     * @return
     */
    Mobstockin selectByPrimaryKey(String invoiceid);

    /**
     * 可根据传入字段是否为空动态更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKeySelective(Mobstockin record);

    /**
     * 通过主键更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKey(Mobstockin record);

    /**
     *查找所有数据
     * @return
     */
	List<Mobstockin> queryList();

	List<Mobstockin> findMobStockIn(Map<String, String> map);
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