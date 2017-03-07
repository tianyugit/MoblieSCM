package com.sise.dao;

import java.util.List;

import com.sise.pojo.Customertype;


public interface CustomertypeDao {
	/**
	 * ͨ������ɾ������
	 * @param custtypeid ����
	 * @return
	 */
    int deleteByPrimaryKey(String custtypeid);

    /**
     * ��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insert(Customertype record);

    /**
     * �ɸ��������Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insertSelective(Customertype record);

    /**
     * ͨ��������������
     * @param custtypeid
     * @return
     */
    Customertype selectByPrimaryKey(String custtypeid);

    /**
     * �ɸ��ݴ����ֶ��Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKeySelective(Customertype record);

    /**
     * ͨ��������������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKey(Customertype record);

    /**
     * ��ȡ��������
     * @return
     */
	List<Customertype> getTypeList();
}