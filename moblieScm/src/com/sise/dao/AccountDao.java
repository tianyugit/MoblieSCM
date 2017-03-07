package com.sise.dao;

import java.util.List;

import com.sise.pojo.Account;


public interface AccountDao {
	/**
	 * 通过主键删除数据
	 * @param accountid 主键
	 * @return
	 */
    int deleteByPrimaryKey(String accountid);

    /**
     * 插入数据
     * @param record 要插入的对象
     * @return
     */
    int insert(Account record);

    /**
     * 可根据数据是否为空动态插入数据
     * @param record 要插入的对象
     * @return
     */
    int insertSelective(Account record);

    /**
     * 通过主键搜索数据
     * @param invoiceid
     * @return
     */
    Account selectByPrimaryKey(String accountid);

    /**
     * 可根据传入字段是否为空动态更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKeySelective(Account record);

    /**
     * 通过主键更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKey(Account record);

    /**
     * 获取所有数据
     * @return
     */
	List<Account> getList();
}