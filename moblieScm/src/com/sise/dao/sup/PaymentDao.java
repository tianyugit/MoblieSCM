package com.sise.dao.sup;

import java.util.List;

import com.sise.pojo.Payment;


public interface PaymentDao {
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
    int insert(Payment record);

    /**
     * �ɸ��������Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insertSelective(Payment record);

    /**
     * ͨ��������������
     * @param invoiceid
     * @return
     */
    Payment selectByPrimaryKey(String invoiceid);

    /**
     * �ɸ��ݴ����ֶ��Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKeySelective(Payment record);

    /**
     * ͨ��������������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKey(Payment record);

    /**
     * ��ȡ��������
     * @return
     */
	List<Payment> getList();

	List<Payment> findPaymentBySupplier(String supplierid);

}