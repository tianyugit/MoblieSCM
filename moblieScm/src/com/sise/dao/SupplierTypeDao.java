package com.sise.dao;

import java.util.List;

import com.sise.pojo.SupplierType;


public interface SupplierTypeDao {
	/**
	 * ͨ������ɾ������
	 * @param suptypeid ����
	 * @return
	 */
    int deleteByPrimaryKey(String suptypeid);

    /**
     * ��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insert(SupplierType record);

    /**
     * �ɸ��������Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insertSelective(SupplierType record);

    /**
     * ͨ��������������
     * @param invoiceid
     * @return
     */
    SupplierType selectByPrimaryKey(String suptypeid);

    /**
     * �ɸ��ݴ����ֶ��Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKeySelective(SupplierType record);

    /**
     * ͨ��������������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKey(SupplierType record);

    /**
     * ��ȡ��������
     * @return
     */
	List<SupplierType> getTypeList();
}