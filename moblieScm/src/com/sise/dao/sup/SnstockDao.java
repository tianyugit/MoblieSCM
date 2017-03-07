package com.sise.dao.sup;

import java.util.List;
import java.util.Map;

import com.sise.pojo.SnStock;
import com.sise.pojo.SupStockinsn;


public interface SnstockDao {
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
    int insert(SnStock record);

    /**
     * �ɸ��������Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insertSelective(SnStock record);

    /**
     * ͨ��������������
     * @param invoiceid
     * @return
     */
    SnStock selectByPrimaryKey(String id);

    /**
     * �ɸ��ݴ����ֶ��Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKeySelective(SnStock record);

    /**
     * ͨ��������������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKey(SnStock record);

    /**
     * ͨ�������map����map�е�����
     * @param snMap
     */
	void insertByMap(Map<String, String> snMap);

	/**
	 * ͨ��InvoiceId��ȡSnStockin
	 * @param invoiceid
	 * @return
	 */
	List<SnStock> getSnStockinByInvoiceId(String invoiceid);

	/**
	 * ͨ��invoiceidɾ��SN��
	 * @param invoiceid
	 */
	void deleteByInvoiceId(String invoiceid);
}