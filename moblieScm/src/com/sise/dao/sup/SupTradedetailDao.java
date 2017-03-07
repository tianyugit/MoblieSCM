package com.sise.dao.sup;

import java.util.List;
import java.util.Map;

import com.sise.pojo.SupMobreturn;
import com.sise.pojo.SupTradedetail;

public interface SupTradedetailDao {
	/**
	 * ͨ������ɾ������
	 * @param id ����
	 * @return
	 */
    int deleteByPrimaryKey(String invoiceid);

    /**
     * ��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insert(SupTradedetail record);

    /**
     * �ɸ��������Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insertSelective(SupTradedetail record);

    /**
     * ͨ��������������
     * @param invoiceid
     * @return
     */
    SupTradedetail selectByPrimaryKey(String invoiceid);

    /**
     * �ɸ��ݴ����ֶ��Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKeySelective(SupTradedetail record);

    /**
     * ͨ��������������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKey(SupTradedetail record);

    /**
     * ������������
     * @return
     */
	List<SupTradedetail> queryList();

	/**
	 * @param map
	 * @return
	 */
	List<SupTradedetail> findTDlBySelected(Map<String, String> map);

	/**
	 * @param map
	 * @return
	 */
	List<SupTradedetail> queryListLimitDate(Map map);
	
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
	List<SupTradedetail> findAllWithFy(Map map, int i, int j);
}