package com.sise.dao;

import java.util.List;

import com.sise.pojo.Account;


public interface AccountDao {
	/**
	 * ͨ������ɾ������
	 * @param accountid ����
	 * @return
	 */
    int deleteByPrimaryKey(String accountid);

    /**
     * ��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insert(Account record);

    /**
     * �ɸ��������Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insertSelective(Account record);

    /**
     * ͨ��������������
     * @param invoiceid
     * @return
     */
    Account selectByPrimaryKey(String accountid);

    /**
     * �ɸ��ݴ����ֶ��Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKeySelective(Account record);

    /**
     * ͨ��������������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKey(Account record);

    /**
     * ��ȡ��������
     * @return
     */
	List<Account> getList();
}