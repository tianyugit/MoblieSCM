package com.sise.dao;

import java.util.List;
import java.util.Map;

import com.sise.pojo.MobTonus;


public interface MobtonusDao {
	/**
	 * 通过主键删除数据
	 * @param id 主键
	 * @return
	 */
    int deleteByPrimaryKey(String id);

    /**
     * 插入数据
     * @param record 要插入的对象
     * @return
     */
    int insert(MobTonus record);

    /**
     * 可根据数据是否为空动态插入数据
     * @param record 要插入的对象
     * @return
     */
    int insertSelective(MobTonus record);

    /**
     * 通过主键搜索数据
     * @param invoiceid
     * @return
     */
    MobTonus selectByPrimaryKey(String id);

    /**
     * 可根据传入字段是否为空动态更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKeySelective(MobTonus record);

    /**
     * 通过主键更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKey(MobTonus record);

    /**
     * 获取所有数据
     * @param mobTypeId
     * @return
     */
	List<MobTonus> queryList(String mobTypeId);

	/**
	 * 通过Mobtypeid删除
	 * @param mobtypeid
	 */
	void deleteByMobtypeid(String mobtypeid);
}