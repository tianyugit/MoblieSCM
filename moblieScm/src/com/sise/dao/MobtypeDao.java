package com.sise.dao;

import java.util.List;
import java.util.Map;

import com.sise.pojo.Mobtype;


public interface MobtypeDao {
	/**
	 * ͨ������ɾ������
	 * @param mobtypeid ����
	 * @return
	 */
    int deleteByPrimaryKey(String mobtypeid);

    /**
     * ��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insert(Mobtype record);

    /**
     * �ɸ��������Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insertSelective(Mobtype record);

    /**
     * ͨ��������������
     * @param mobtypeid
     * @return
     */
    Mobtype selectByPrimaryKey(String mobtypeid);

    /**
     * �ɸ��ݴ����ֶ��Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKeySelective(Mobtype record);

    /**
     * ͨ��������������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKey(Mobtype record);
    
    /**
     * ��ȡ��������
     * @param strings ��������
     * @return
     */
    public List queryList(String... strings);

    /**
     * ͨ��Ʒ�Ʋ����ֻ����
     * @param brand
     * @return
     */
	List<Mobtype> findMobTypeByBrand(String brand);

	/**
	 * @param map
	 * @return
	 */
	List findMobtypeBySelected(Map<String, String> map);
}