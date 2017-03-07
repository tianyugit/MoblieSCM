package com.sise.service.cust;

import java.util.List;
import java.util.Map;

import com.sise.pojo.CustMobsale;
import com.sise.pojo.CustMobsalesn;
import com.sise.pojo.CustTradedetail;

public interface CustMobsaleService {

	void add(CustMobsale mobReturn, CustTradedetail custtradedetail,
			List<Map> snList) throws Exception;

	List<CustMobsale> getList(String string);

	void updateCheck(CustMobsale mobSale, CustTradedetail custtradedetail,
			List<CustMobsalesn> custMobsalesnList);

	/**É¾³ýÏúÊÛµ¥
	 * @param mobSale
	 */
	void delete(CustMobsale mobSale);

}
