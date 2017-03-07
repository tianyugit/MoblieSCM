package com.sise.dao;

import java.util.List;

import com.sise.pojo.Config;



public interface ConfigDao {
	/**
	 * ͨ������ɾ������
	 * @param config ����
	 * @return
	 */
    int deleteByPrimaryKey(String config);

    /**
     * ��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insert(Config record);

    /**
     * �ɸ��������Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insertSelective(Config record);

    /**
     * ��ȡ��������
     * @param strings ��������
     * @return
     */
	List queryList(String... strings);
}