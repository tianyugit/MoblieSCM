package com.sise.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sise.dao.sup.MobreturnDao;
import com.sise.dao.sup.MobstockDao;
import com.sise.dao.sup.MobstocksnoutDao;
import com.sise.dao.sup.SupTradedetailDao;
import com.sise.pojo.Mobstock;
import com.sise.pojo.SupMobreturn;
import com.sise.pojo.SupMobstocksnout;
import com.sise.pojo.SupStockinsn;
import com.sise.pojo.SupTradedetail;

public class MobReturnServiceImpl implements MobReturnService{
	
	private MobreturnDao mobreturnDao;
	private SupTradedetailDao supTradedetailDao;
	private MobstocksnoutDao mobstocksnoutDao;
	private MobstockDao mobstockDao;
	private List<SupMobstocksnout> mobstocksnoutList;

	public void add(SupMobreturn mobreturn, SupTradedetail suptradedetail,
			List<Map> snList) {
		mobreturnDao.insertSelective(mobreturn);
		supTradedetailDao.insertSelective(suptradedetail);
		Iterator it = snList.iterator();
		while (it.hasNext()) {
			Map<String,String> snMap = (Map<String,String>) it.next();
			mobstocksnoutDao.insertByMap(snMap);
		}
		
	}
	
	public void delete(SupMobreturn mobreturn) {
		mobstocksnoutList = mobstocksnoutDao.getSnByInvoiceid(mobreturn);
		Iterator it = mobstocksnoutList.iterator();
		while (it.hasNext()) {
			SupMobstocksnout next = (SupMobstocksnout) it.next();
			mobstocksnoutDao.deleteByPrimaryKey(next.getId());
		}
		mobreturnDao.deleteByPrimaryKey(mobreturn.getInvoiceid());
		supTradedetailDao.deleteByPrimaryKey(mobreturn.getInvoiceid());
	}
	
	public void updateCheck(SupMobreturn mobreturn,
			SupTradedetail suptradedetail,
			List<SupMobstocksnout> mobStocksnoutList) {
		mobreturnDao.updateByPrimaryKeySelective(mobreturn);
		supTradedetailDao.updateByPrimaryKeySelective(suptradedetail);
		//int test = 1/0;
		Iterator it = mobStocksnoutList.iterator();
		while(it.hasNext()){
			SupMobstocksnout supStockinsn = (SupMobstocksnout) it.next();
			/*Mobstock mobstock = new Mobstock();
			mobstock.setSn1(supStockinsn.getSn1());*/
			//mobstock.setStatus(mobreturn.getStatus());
			//System.out.println(mobstock);
			mobstockDao.deleteByPrimaryKey(supStockinsn.getSn1());
		}
		
	}
	
	public List<SupMobreturn> queryList(String string) {
			// TODO Auto-generated method stub
			return mobreturnDao.queryList("");
	}
	public void setMobreturnDao(MobreturnDao mobreturnDao) {
		this.mobreturnDao = mobreturnDao;
	}

	public void setSupTradedetailDao(SupTradedetailDao supTradedetailDao) {
		this.supTradedetailDao = supTradedetailDao;
	}

	public void setMobstocksnoutDao(MobstocksnoutDao mobstocksnoutDao) {
		this.mobstocksnoutDao = mobstocksnoutDao;
	}

	public void setMobstockDao(MobstockDao mobstockDao) {
		this.mobstockDao = mobstockDao;
	}

}
