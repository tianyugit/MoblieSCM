package com.sise.dao;

import java.util.List;
import java.util.Map;

import com.sise.pojo.Bonustype;

@SuppressWarnings({ "rawtypes" })
public interface BonustypeDao {
	/**
	 * 通过主键删除数据
	 * @param bonustypeid
	 * @return
	 * @throws Exception
	 */
    int deleteByPrimaryKey(String bonustypeid) throws Exception;

    /**
     * 插入数据
     * @param record 要插入的对象
     *  @return
     * @throws Exception
     */
    int insert(Bonustype record) throws Exception;

    /**
     * 可根据数据是否为空动态插入数据
     * @param record 要插入的对象
     * @return
     * @throws Exception
     */
    int insertSelective(Bonustype record) throws Exception;

    /**
     * 通过主键搜索数据
     * @param invoiceid
     * @return
     * @throws Exception
     */
    Bonustype selectByPrimaryKey(String bonustypeid) throws Exception;

    /**
     * 可根据传入字段是否为空动态更新数据
     * @param record 要更新的对象
     * @return
     * @throws Exception
     */
    int updateByPrimaryKeySelective(Bonustype record) throws Exception;

    /**
     * 通过主键更新数据
     * @param record 要更新的对象
     * @return
     * @throws Exception
     */
    int updateByPrimaryKey(Bonustype record) throws Exception;

    /**
     * 查找所有数据
     * @return
     * @throws Exception
     */
	List queryList() throws Exception;

	/**
	 * 通过名字查找返价类别
	 * @param string
	 * @return
	 * @throws Exception
	 */
	Bonustype findBonustypeByName(String string) throws Exception;

	/**
	 * 通过型号id找返利
	 * @param mobTypeId
	 * @return
	 */
	List<Map> getBonus(String mobTypeId);

	
}