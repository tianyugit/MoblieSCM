package com.sise.dao.sup;

import java.util.List;
import java.util.Map;

import com.sise.pojo.SupMobreturn;
import com.sise.pojo.SupMobstocksnout;
import com.sise.pojo.SupStockinsn;

public interface MobstocksnoutDao {
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
    int insert(SupMobstocksnout record);

    /**
     * �ɸ��������Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insertSelective(SupMobstocksnout record);

    /**
     * ͨ��������������
     * @param invoiceid
     * @return
     */
    SupMobstocksnout selectByPrimaryKey(String id);

    /**
     * �ɸ��ݴ����ֶ��Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKeySelective(SupMobstocksnout record);

    /**
     * ͨ��������������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKey(SupMobstocksnout record);

    /**
     * ͨ�������map����map�е�����
     * @param snMap
     */
	void insertByMap(Map<String, String> snMap);

	/**
	 * ͨ��Invoiceid�ҵ�sn
	 * @param mobreturn
	 * @return
	 */
	List<SupMobstocksnout> getSnByInvoiceid(SupMobreturn mobreturn);


}