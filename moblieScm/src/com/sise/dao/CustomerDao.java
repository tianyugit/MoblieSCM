package com.sise.dao;

import java.util.List;
import java.util.Map;

import com.sise.pojo.Customer;
import com.sise.pojo.JsonBean;
import com.sise.pojo.JsonBean_data;


public interface CustomerDao {
	/**
	 * 通过主键删除数据
	 * @param custid 主键
	 * @return
	 */
    int deleteByPrimaryKey(String custid);

    /**
     * 插入数据
     * @param record 要插入的对象
     * @return
     */
    int insert(Customer record);

    /**
     * 可根据数据是否为空动态插入数据
     * @param record 要插入的对象
     * @return
     */
    int insertSelective(Customer record);

    /**
     * 通过主键搜索数据
     * @param invoiceid
     * @return
     */
    Customer selectByPrimaryKey(String custid);

    /**
     * 可根据传入字段是否为空动态更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKeySelective(Customer record);

    /**
     * 通过主键更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKey(Customer record);

    /**
     * 获取所有数据
     * @param strings 参数数组
     * @return
     */
	List<Customer> getCustomerList(String... strings);

	/**
	 * 查找客户
	 * @param map
	 * @return
	 */
	List<Customer> findCustomer(Map<String, String> map);

	/**
	 * 查找客户返回jsonbean
	 * @param map
	 * @return
	 */
	List<JsonBean> findCust(Map<String, String> map);

	/**
	 * 通过名字查找客户
	 * @param custName
	 * @return
	 */
	Customer findCustByName(String custName);

	/**
	 * 获取客户列表
	 * @return
	 */
	List<Customer> queryList();
	
	
	
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
	List<Customer> findAllWithFy(Map map, int i, int j);
}