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
	 * 添加入库单
	 * @param msi 入库单
	 * @param suptradedetail 供应商
	 * @param snList 串号集合
	 */
	void addInvoice(Mobstockin msi, SupTradedetail suptradedetail,
			List<Map> snList);

	/**
	 * 获取入库单所有数据
	 * @return
	 */
	List<Mobstockin> queryList();

	/**
	 * 审核入库单
	 * @param msi 入库单
	 * @param suptradedetail 供应商
	 * @param mobStockList 库存
	 */
	void updateCheck(Mobstockin msi, SupTradedetail suptradedetail,
			List<SupStockinsn> mobStockList);

	/**
	 * 查找入库表
	 * @return
	 */
	List<Mobstockin> findMobStockIn();

	List<Mobstockin> findMobStockIn(Map<String, String> map);

	/**删除入库单
	 * @param msi
	 */
	void delete(Mobstockin msi);

	/**通过单号id查找入库单
	 * @param invoiceid
	 * @return
	 */
	Mobstockin getmobStockInByid(String invoiceid);

	/**修改入库单
	 * @param msi
	 * @param suptradedetail
	 * @param snList
	 */
	void update(Mobstockin msi, SupTradedetail suptradedetail, List<Map> snList);

}
