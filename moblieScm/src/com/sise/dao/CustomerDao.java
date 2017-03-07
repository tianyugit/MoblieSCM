package com.sise.dao;

import java.util.List;
import java.util.Map;

import com.sise.pojo.Customer;
import com.sise.pojo.JsonBean;
import com.sise.pojo.JsonBean_data;


public interface CustomerDao {
	/**
	 * ͨ������ɾ������
	 * @param custid ����
	 * @return
	 */
    int deleteByPrimaryKey(String custid);

    /**
     * ��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insert(Customer record);

    /**
     * �ɸ��������Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insertSelective(Customer record);

    /**
     * ͨ��������������
     * @param invoiceid
     * @return
     */
    Customer selectByPrimaryKey(String custid);

    /**
     * �ɸ��ݴ����ֶ��Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKeySelective(Customer record);

    /**
     * ͨ��������������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKey(Customer record);

    /**
     * ��ȡ��������
     * @param strings ��������
     * @return
     */
	List<Customer> getCustomerList(String... strings);

	/**
	 * ���ҿͻ�
	 * @param map
	 * @return
	 */
	List<Customer> findCustomer(Map<String, String> map);

	/**
	 * ���ҿͻ�����jsonbean
	 * @param map
	 * @return
	 */
	List<JsonBean> findCust(Map<String, String> map);

	/**
	 * ͨ�����ֲ��ҿͻ�
	 * @param custName
	 * @return
	 */
	Customer findCustByName(String custName);

	/**
	 * ��ȡ�ͻ��б�
	 * @return
	 */
	List<Customer> queryList();
	
	
	
	/**
	 * ��ȡ��ҳ�ܳ���
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