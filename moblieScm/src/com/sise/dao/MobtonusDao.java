package com.sise.dao;

import java.util.List;
import java.util.Map;

import com.sise.pojo.MobTonus;


public interface MobtonusDao {
	/**
	 * ͨ������ɾ������
	 * @param id ����
	 * @return
	 */
    int deleteByPrimaryKey(String id);

    /**
     * ��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insert(MobTonus record);

    /**
     * �ɸ��������Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insertSelective(MobTonus record);

    /**
     * ͨ��������������
     * @param invoiceid
     * @return
     */
    MobTonus selectByPrimaryKey(String id);

    /**
     * �ɸ��ݴ����ֶ��Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKeySelective(MobTonus record);

    /**
     * ͨ��������������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKey(MobTonus record);

    /**
     * ��ȡ��������
     * @param mobTypeId
     * @return
     */
	List<MobTonus> queryList(String mobTypeId);

	/**
	 * ͨ��Mobtypeidɾ��
	 * @param mobtypeid
	 */
	void deleteByMobtypeid(String mobtypeid);
}