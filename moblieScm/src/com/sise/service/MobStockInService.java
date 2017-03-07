package com.sise.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.sise.pojo.Mobstock;
import com.sise.pojo.Mobstockin;
import com.sise.pojo.SupStockinsn;
import com.sise.pojo.SupTradedetail;

public interface MobStockInService {

	/**
	 * �����ⵥ
	 * @param msi ��ⵥ
	 * @param suptradedetail ��Ӧ��
	 * @param snList ���ż���
	 */
	void addInvoice(Mobstockin msi, SupTradedetail suptradedetail,
			List<Map> snList);

	/**
	 * ��ȡ��ⵥ��������
	 * @return
	 */
	List<Mobstockin> queryList();

	/**
	 * �����ⵥ
	 * @param msi ��ⵥ
	 * @param suptradedetail ��Ӧ��
	 * @param mobStockList ���
	 */
	void updateCheck(Mobstockin msi, SupTradedetail suptradedetail,
			List<SupStockinsn> mobStockList);

	/**
	 * ��������
	 * @return
	 */
	List<Mobstockin> findMobStockIn();

	List<Mobstockin> findMobStockIn(Map<String, String> map);

	/**ɾ����ⵥ
	 * @param msi
	 */
	void delete(Mobstockin msi);

	/**ͨ������id������ⵥ
	 * @param invoiceid
	 * @return
	 */
	Mobstockin getmobStockInByid(String invoiceid);

	/**�޸���ⵥ
	 * @param msi
	 * @param suptradedetail
	 * @param snList
	 */
	void update(Mobstockin msi, SupTradedetail suptradedetail, List<Map> snList);

}
