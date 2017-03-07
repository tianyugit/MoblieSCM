package com.sise.dao;

import java.util.List;
import java.util.Map;

import com.sise.pojo.Supplier;

public interface SupplierDao {
	/**
	 * ͨ������ɾ������
	 * @param supid ����
	 * @return
	 */
    int deleteByPrimaryKey(String supid);

    /**
     * ��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insert(Supplier record);

    /**
     * �ɸ��������Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insertSelective(Supplier record);

    /**
     * ͨ��������������
     * @param supid
     * @return
     */
    Supplier selectByPrimaryKey(String supid);

    /**
     * �ɸ��ݴ����ֶ��Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKeySelective(Supplier record);

    /**
     * ͨ��������������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKey(Supplier record);

    /**
     * ��ȡ��������
     * @param strings ��������
     * @return
     */
	List<Supplier> getSupplierList(String... strings);

	/**
	 * ���ҹ�Ӧ��
	 * @param map
	 * @return
	 */
	List<Supplier> findSupplier(Map<String, String> map);

	/**
	 * ͨ��ajax���ҹ�Ӧ��
	 * @param map
	 * @return
	 */
	List<Supplier> findSupplierAjax(Map<String, String> map);

	List getSupplierList2(String suptypeid);
}