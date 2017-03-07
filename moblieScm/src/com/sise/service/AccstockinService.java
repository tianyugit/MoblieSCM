package com.sise.service;

import java.util.List;
import java.util.Map;

import com.sise.pojo.Accstockin;
import com.sise.pojo.SnStock;
import com.sise.pojo.SupStockinsn;
import com.sise.pojo.SupTradedetail;

public interface AccstockinService {

	void addInvoice(Accstockin asi, SupTradedetail suptradedetail,
			List<Map> snList);

	List<Accstockin> getList();


	void updateCheck(Accstockin asi, SupTradedetail suptradedetail,
			List<SnStock> accStockList);

	void delete(String invoiceid);

	List<Accstockin> getaccType(Map<String, String> map);

}
