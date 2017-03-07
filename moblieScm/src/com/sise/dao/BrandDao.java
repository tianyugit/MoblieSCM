package com.sise.dao;

import java.util.List;

import com.sise.pojo.Brand;

@SuppressWarnings({ "rawtypes" })
public interface BrandDao {
	/**
	 * ͨ������ɾ������
	 * @param brand ����
	 * @return
	 */
    int deleteByPrimaryKey(String brand);

    /**
     * ��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insert(Brand record);

    /**
     * �ɸ��������Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insertSelective(Brand record);
    
    /**
     * ͨ�������ҵ�Ʒ��
     * @param brand
     * @return
     * @throws Exception
     */
    public Brand findBrandByPrimaryKey(String brand) throws Exception;
    
    /**
     * ��ȡ��������
     * @return
     * @throws Exception
     */
    public List queryList() throws Exception;
}