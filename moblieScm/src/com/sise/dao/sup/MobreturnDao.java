package com.sise.dao.sup;

import java.util.List;

import com.sise.pojo.Mobstockin;
import com.sise.pojo.SupMobreturn;

public interface MobreturnDao {
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
    int insert(SupMobreturn record);

    /**
     * �ɸ��������Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ����Ķ���
     * @return
     */
    int insertSelective(SupMobreturn record);

    /**
     * ͨ��������������
     * @param invoiceid
     * @return
     */
    SupMobreturn selectByPrimaryKey(String invoiceid);

    /**
     * �ɸ��ݴ����ֶ��Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKeySelective(SupMobreturn record);

    /**
     * ͨ��������������
     * @param record Ҫ���µĶ���
     * @return
     */
    int updateByPrimaryKey(SupMobreturn record);

    /**
     * ��ȡSupMobreturn�����������
     * @param string
     * @return
     */
	List<SupMobreturn> queryList(String string);
	
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
	public List<SupMobreturn> findAllWithFy(int start, int size) throws Exception;
}