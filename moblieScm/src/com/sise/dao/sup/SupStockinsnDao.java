package com.sise.dao.sup;

import java.util.List;
import java.util.Map;

import com.sise.pojo.Mobstock;
import com.sise.pojo.SupStockinsn;

public interface SupStockinsnDao {
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
    int insert(SupStockinsn record);

    /**
     * �ɸ��������Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insertSelective(SupStockinsn record);

    /**
     * ͨ��������������
     * @param invoiceid
     * @return
     */
    SupStockinsn selectByPrimaryKey(String id);

    /**
     * �ɸ��ݴ����ֶ��Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKeySelective(SupStockinsn record);

    /**
     * ͨ��������������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKey(SupStockinsn record);

    /**
     * ͨ�������map����map�е�����
     * @param snMap
     */
	void insertByMap(Map<String, String> snMap);

	/**
	 * ͨ��InvoiceId��ȡSupStockinsn
	 * @param invoiceid
	 * @return
	 */
	List<SupStockinsn> getSupStockinsnByInvoiceId(String invoiceid);

	/**ͨ��invoiceidɾ������
	 * @param invoiceid
	 */
	void deleteByInvoiceid(String invoiceid);

}