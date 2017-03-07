package com.sise.dao.sup;

import java.util.List;
import java.util.Map;

import com.sise.pojo.SupMobreturn;
import com.sise.pojo.SupTradedetail;

public interface SupTradedetailDao {
	/**
	 * 通过主键删除数据
	 * @param id 主键
	 * @return
	 */
    int deleteByPrimaryKey(String invoiceid);

    /**
     * 插入数据
     * @param record 要插入的对象
     * @return
     */
    int insert(SupTradedetail record);

    /**
     * 可根据数据是否为空动态插入数据
     * @param record 要插入的对象
     * @return
     */
    int insertSelective(SupTradedetail record);

    /**
     * 通过主键搜索数据
     * @param invoiceid
     * @return
     */
    SupTradedetail selectByPrimaryKey(String invoiceid);

    /**
     * 可根据传入字段是否为空动态更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKeySelective(SupTradedetail record);

    /**
     * 通过主键更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKey(SupTradedetail record);

    /**
     * 查找所有数据
     * @return
     */
	List<SupTradedetail> queryList();

	/**
	 * @param map
	 * @return
	 */
	List<SupTradedetail> findTDlBySelected(Map<String, String> map);

	/**
	 * @param map
	 * @return
	 */
	List<SupTradedetail> queryListLimitDate(Map map);
	
	/**
	 * 获取分页总长度
	 * @return
	 */
	int getPageLong();

	/**
	 * @param map
	 * @param i
	 * @param j
	 * @return
	 */
	List<SupTradedetail> findAllWithFy(Map map, int i, int j);
}