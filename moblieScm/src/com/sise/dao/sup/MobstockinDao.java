package com.sise.dao.sup;

import java.util.List;
import java.util.Map;

import com.sise.pojo.Mobstockin;
import com.sise.pojo.User;


public interface MobstockinDao {
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
    int insert(Mobstockin record);

    /**
     * �ɸ��������Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insertSelective(Mobstockin record);

    /**
     * ͨ��������������
     * @param invoiceid
     * @return
     */
    Mobstockin selectByPrimaryKey(String invoiceid);

    /**
     * �ɸ��ݴ����ֶ��Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKeySelective(Mobstockin record);

    /**
     * ͨ��������������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKey(Mobstockin record);

    /**
     *������������
     * @return
     */
	List<Mobstockin> queryList();

	List<Mobstockin> findMobStockIn(Map<String, String> map);
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