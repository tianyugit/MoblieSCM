package com.sise.dao.sup;

import java.util.List;

import com.sise.pojo.Payment;


public interface PaymentDao {
	/**
	 * 通过主键删除数据
	 * @param invoiceid 主键
	 * @return
	 */
    int deleteByPrimaryKey(String invoiceid);

    /**
     * 插入数据
     * @param record 要插入的对象
     * @return
     */
    int insert(Payment record);

    /**
     * 可根据数据是否为空动态插入数据
     * @param record 要插入的对象
     * @return
     */
    int insertSelective(Payment record);

    /**
     * 通过主键搜索数据
     * @param invoiceid
     * @return
     */
    Payment selectByPrimaryKey(String invoiceid);

    /**
     * 可根据传入字段是否为空动态更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKeySelective(Payment record);

    /**
     * 通过主键更新数据
     * @param record 要更新的对象
     * @return
     */
    int updateByPrimaryKey(Payment record);

    /**
     * 获取所有数据
     * @return
     */
	List<Payment> getList();

	List<Payment> findPaymentBySupplier(String supplierid);

}