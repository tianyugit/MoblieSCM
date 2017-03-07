package com.sise.dao.cust;

import java.util.List;
import java.util.Map;

import com.sise.pojo.CustMobsale;
import com.sise.pojo.CustMobsalesn;

public interface CustMobsalesnDao {
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
    int insert(CustMobsalesn record);

    /**
     * �ɸ��������Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insertSelective(CustMobsalesn record);

    /**
     * ͨ��������������
     * @param invoiceid
     * @return
     */
    CustMobsalesn selectByPrimaryKey(String id);

    /**
     * �ɸ��ݴ����ֶ��Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKeySelective(CustMobsalesn record);

    /**
     * ͨ��������������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKey(CustMobsalesn record);

    /**
     * ͨ�������map����map�е�����
     * @param snMap
     */
	void insertByMap(Map<String, String> snMap);

	/**
	 * ͨ�����Ż�ȡ����
	 * @param mobSale
	 * @return
	 */
	List<CustMobsalesn> getSnByInvoiceid(CustMobsale mobSale);
}