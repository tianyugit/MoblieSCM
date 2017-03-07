package com.sise.dao;

import java.util.List;

import com.sise.pojo.Brand;
import com.sise.pojo.Color;

public interface ColorDao {
	/**
	 * ͨ������ɾ������
	 * @param color ����
	 * @return
	 */
    int deleteByPrimaryKey(String color);

    /**
     * ��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insert(Color record);

    /**
     * �ɸ��������Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insertSelective(Color record);
    
    /**
     * ͨ������������ɫ
     * @param color ����
     * @return
     * @throws Exception
     */
    public Color findColorByPrimaryKey(String color) throws Exception;
    
    /**
     * ��ȡ��������
     * @return
     * @throws Exception
     */
    public List queryList() throws Exception;
}