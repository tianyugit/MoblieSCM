package com.sise.dao.sup;

import java.util.List;

import com.sise.pojo.JsonBean_data;
import com.sise.pojo.Mobstock;
import com.sise.pojo.StoCount;

public interface MobstockDao {
	/**
	 * ͨ������ɾ������
	 * @param sn1 ����
	 * @return
	 */
    int deleteByPrimaryKey(String sn1);

    /**
     * ��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insert(Mobstock record);

    /**
     * �ɸ��������Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insertSelective(Mobstock record);

    /**
     * ͨ��������������
     * @param invoiceid
     * @return
     */
    Mobstock selectByPrimaryKey(String sn1);

    /**
     * �ɸ��ݴ����ֶ��Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKeySelective(Mobstock record);

    /**
     * ͨ��������������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKey(Mobstock record);

    /**
     *ͨ��sn2��������
     * @param record Ҫ���µĶ���
     * @return
     */
	Mobstock selectByPrimaryKey2(String sn2);

	/**
	 * ����Mobtype����
	 * @return
	 */
	List<StoCount> countMobtype();

	/**
	 * ͨ��mobTypeId����mobStock
	 * @param mobtypeid
	 * @return
	 */
	List<Mobstock> findmobStockBymobTypeId(String mobtypeid);

	/**
	 * ��ȡ��������
	 * @return
	 */
	List<JsonBean_data> getSRFormData();

	/*List<Mobstock> findmobStockByInvoiceId(String invoiceid);*/

}