package com.sise.dao.sup;

import java.util.List;

import com.sise.pojo.AccStock;
import com.sise.pojo.Mobstockin;
import com.sise.pojo.StoCount;


public interface AccstockDao {
	/**
	 * ͨ������ɾ������
	 * @param sn ����
	 * @return
	 */
    int deleteByPrimaryKey(String sn);
    /**
     * ��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insert(AccStock record);
    /**
     * �ɸ��������Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insertSelective(AccStock record);
    /**
     * ͨ��������������
     * @param sn
     * @return
     */
    AccStock selectByPrimaryKey(String sn);
    /**
     * �ɸ��ݴ����ֶ��Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKeySelective(AccStock record);
    /**
     * ����������������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKey(AccStock record);
    /**
     * �������͸���
     * @return ��������䵽StoCount������
     */
	List<StoCount> countAccType();
	/**
	 * ͨ��accTypeId����mobStock
	 * @param accessorytypeid
	 * @return
	 */
	List<AccStock> findmobStockByaccTypeId(String accessorytypeid);
	
	/**
	 * ��ȡ��ҳ�ܳ���
	 * @return
	 */
	int getPageLong();
	/**
	 * ��ѯ��ҳ����
	 * @param start
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public List<Mobstockin> findAllWithFy(int start, int size) throws Exception;
}