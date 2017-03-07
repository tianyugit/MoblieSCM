package com.sise.dao.cust;

import java.util.List;
import java.util.Map;

import com.sise.pojo.CustTradedetail;
import com.sise.pojo.SupTradedetail;

public interface CustTradedetailDao {
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
    int insert(CustTradedetail record);

    /**
     * �ɸ��������Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insertSelective(CustTradedetail record);

    /**
     * ͨ��������������
     * @param invoiceid
     * @return
     */
    CustTradedetail selectByPrimaryKey(String invoiceid);

    /**
     * �ɸ��ݴ����ֶ��Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKeySelective(CustTradedetail record);

    /**
     * ͨ��������������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKey(CustTradedetail record);

    /**
     * ������������
     * @return
     */
	List<CustTradedetail> queryList();
	
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
	List<CustTradedetail> findAllWithFy(Map map, int i, int j);
}