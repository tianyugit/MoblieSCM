package com.sise.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sise.dao.sup.AccstockDao;
import com.sise.dao.sup.AccstockinDao;
import com.sise.dao.sup.SnstockDao;
import com.sise.dao.sup.SupTradedetailDao;
import com.sise.pojo.AccStock;
import com.sise.pojo.Accstockin;
import com.sise.pojo.Mobstock;
import com.sise.pojo.SnStock;
import com.sise.pojo.SupStockinsn;
import com.sise.pojo.SupTradedetail;

public class AccstockinServiceImpl implements AccstockinService{
	
	private AccstockinDao accstockinDao;
	private SupTradedetailDao supTradedetailDao;
	private SnstockDao snstockDao;
	private AccstockDao accstockDao;
	public void setAccstockinDao(AccstockinDao accstockinDao) {
		this.accstockinDao = accstockinDao;
	}

	public void setSupTradedetailDao(SupTradedetailDao supTradedetailDao) {
		this.supTradedetailDao = supTradedetailDao;
	}

	public void setSnstockDao(SnstockDao snstockDao) {
		this.snstockDao = snstockDao;
	}

	public void addInvoice(Accstockin asi, SupTradedetail suptradedetail,
			List<Map> snList) {
		accstockinDao.insertSelective(asi);
		supTradedetailDao.insertSelective(suptradedetail);
		Iterator it = snList.iterator();
		while (it.hasNext()) {
			Map<String,String> snMap = (Map<String,String>) it.next();
			snstockDao.insertByMap(snMap);
		}
	}
	
	public void updateCheck(Accstockin asi, SupTradedetail suptradedetail,
				List<SnStock> accStockList) {
		accstockinDao.updateByPrimaryKeySelective(asi);
		supTradedetailDao.updateByPrimaryKeySelective(suptradedetail);
		//int test = 1/0;
		Iterator it = accStockList.iterator();
		while(it.hasNext()){
			SnStock snStockin = (SnStock) it.next();
			AccStock accstock = new AccStock();
			accstock.setSn(snStockin.getSn());
			accstock.setStatus(asi.getStatus());
			System.out.println(accstock);
			accstockDao.updateByPrimaryKeySelective(accstock);
		}
			
	}

	public void delete(String invoiceid) {
		snstockDao.deleteByInvoiceId(invoiceid);
		accstockinDao.deleteByPrimaryKey(invoiceid);
		
	}
	
	public List<Accstockin> getaccType(Map<String, String> map) {
		// TODO Auto-generated method stub
		return accstockinDao.getaccTypeByMap(map);
	}
	
	public List<Accstockin> getList() {
		return accstockinDao.getList();
	}

	public void setAccstockDao(AccstockDao accstockDao) {
		this.accstockDao = accstockDao;
	}

}
