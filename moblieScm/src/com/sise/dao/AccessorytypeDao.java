package com.sise.dao;

import java.util.List;
import java.util.Map;

import com.sise.pojo.Accessorytype;


public interface AccessorytypeDao {
	/**
	 * ͨ������ɾ������
	 * @param accessorytypeid ����
	 * @return
	 */
    int deleteByPrimaryKey(String accessorytypeid);

    /**
     * ��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insert(Accessorytype record);

    /**
     * �ɸ��������Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insertSelective(Accessorytype record);

    /**
     * ͨ��������������
     * @param invoiceid
     * @return
     */
    Accessorytype selectByPrimaryKey(String accessorytypeid);

    /**
     * �ɸ��ݴ����ֶ��Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKeySelective(Accessorytype record);

    /**
     * ͨ��������������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKey(Accessorytype record);

    /**
     * ��ȡ��������
     * @return
     */
	List<Accessorytype> getTypeList();

	/**
	 * ͨ��map����AccessoryType
	 * @param map
	 * @return
	 */
	List<Accessorytype> findAccessoryType(Map<String, String> map);

	/**
	 * ͨ��Ʒ�Ʋ���AccType
	 * @param brand
	 * @return
	 */
	List<Accessorytype> findAccTypeByBrand(String brand);

	List<Accessorytype> findaccTypeByselected(Map<String, String> map);
}