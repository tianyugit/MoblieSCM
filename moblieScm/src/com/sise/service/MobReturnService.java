package com.sise.service;

import java.util.List;
import java.util.Map;

import com.sise.pojo.SupMobreturn;
import com.sise.pojo.SupMobstocksnout;
import com.sise.pojo.SupStockinsn;
import com.sise.pojo.SupTradedetail;

public interface MobReturnService {

	void add(SupMobreturn mobreturn, SupTradedetail suptradedetail,
			List<Map> snList);

	List<SupMobreturn> queryList(String string);

	void delete(SupMobreturn mobreturn);

	void updateCheck(SupMobreturn mobreturn, SupTradedetail suptradedetail,
			List<SupMobstocksnout> mobStocksnoutList);

}
