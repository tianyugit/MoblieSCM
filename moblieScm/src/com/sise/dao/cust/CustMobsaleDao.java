package com.sise.dao.cust;

import java.util.List;
import java.util.Map;

import com.sise.pojo.CustMobsale;
import com.sise.pojo.CustSale;
import com.sise.pojo.JsonBean_data;

public interface CustMobsaleDao {
	/**
	 * ͨ������ɾ������
	 * @param invoiceid ����
	 * @return
	 */
    int deleteByPrimaryKey(String invoiceid);

    /**
     * ��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insert(CustMobsale record);

    /**
     * �ɸ��������Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insertSelective(CustMobsale record);

    /**
     * ͨ��������������
     * @param invoiceid
     * @return
     */
    CustMobsale selectByPrimaryKey(String invoiceid);

    /**
     * �ɸ��ݴ����ֶ��Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKeySelective(CustMobsale record);

    /**
     * ͨ��������������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKey(CustMobsale record);

    /**
     * ��ȡ��������
     * @param string
     * @return
     */
	List<CustMobsale> getList(String string);

	/**
	 * ��ȡ��������
	 * @return
	 */
	List<JsonBean_data> getSRFormData();
	
	/**
	 * ��ȡ��ҳ�ܳ���
	 * @return
	 */
	int getPageLong();

	/**
	 * @param map
	 * @param i
	 * @param j
	 * @return
	 */
	List<CustMobsale> findAllWithFy(Map map, int i, int j);
}