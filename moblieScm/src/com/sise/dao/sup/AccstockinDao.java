package com.sise.dao.sup;

import java.util.List;
import java.util.Map;

import com.sise.pojo.Accstockin;
import com.sise.pojo.Mobstockin;


public interface AccstockinDao {
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
    int insert(Accstockin record);
    
    /**
     * �ɸ��������Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insertSelective(Accstockin record);
    
    /**
     * ͨ��������������
     * @param invoiceid
     * @return
     */
    Accstockin selectByPrimaryKey(String invoiceid);
    
    /**
     * �ɸ��ݴ����ֶ��Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKeySelective(Accstockin record);
    
    /**
     * ����������������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKey(Accstockin record);
    
    /**
     * ��ȡAccstockin�����������
     * @return
     */
	List<Accstockin> getList();

	/**
	 * ͨ��Ʒ�ƺ�������ͻ�ȡ���
	 * @param map
	 * @return
	 */
	List<Accstockin> getaccTypeByMap(Map<String, String> map);
	
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
	public List<Accstockin> findAllWithFy(int start, int size) throws Exception;
}