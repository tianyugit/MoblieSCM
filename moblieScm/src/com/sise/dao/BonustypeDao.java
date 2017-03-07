package com.sise.dao;

import java.util.List;
import java.util.Map;

import com.sise.pojo.Bonustype;

@SuppressWarnings({ "rawtypes" })
public interface BonustypeDao {
	/**
	 * ͨ������ɾ������
	 * @param bonustypeid
	 * @return
	 * @throws Exception
	 */
    int deleteByPrimaryKey(String bonustypeid) throws Exception;

    /**
     * ��������
     * @param record Ҫ����Ķ���
     *  @return
     * @throws Exception
     */
    int insert(Bonustype record) throws Exception;

    /**
     * �ɸ��������Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ����Ķ���
     * @return
     * @throws Exception
     */
    int insertSelective(Bonustype record) throws Exception;

    /**
     * ͨ��������������
     * @param invoiceid
     * @return
     * @throws Exception
     */
    Bonustype selectByPrimaryKey(String bonustypeid) throws Exception;

    /**
     * �ɸ��ݴ����ֶ��Ƿ�Ϊ�ն�̬��������
     * @param record Ҫ���µĶ���
     * @return
     * @throws Exception
     */
    int updateByPrimaryKeySelective(Bonustype record) throws Exception;

    /**
     * ͨ��������������
     * @param record Ҫ���µĶ���
     * @return
     * @throws Exception
     */
    int updateByPrimaryKey(Bonustype record) throws Exception;

    /**
     * ������������
     * @return
     * @throws Exception
     */
	List queryList() throws Exception;

	/**
	 * ͨ�����ֲ��ҷ������
	 * @param string
	 * @return
	 * @throws Exception
	 */
	Bonustype findBonustypeByName(String string) throws Exception;

	/**
	 * ͨ���ͺ�id�ҷ���
	 * @param mobTypeId
	 * @return
	 */
	List<Map> getBonus(String mobTypeId);

	
}