package com.sise.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sise.dao.sup.MobstockDao;
import com.sise.dao.sup.MobstockinDao;
import com.sise.dao.sup.SupStockinsnDao;
import com.sise.dao.sup.SupTradedetailDao;
import com.sise.pojo.Mobstock;
import com.sise.pojo.Mobstockin;
import com.sise.pojo.SupStockinsn;
import com.sise.pojo.SupTradedetail;

public class MobStockInServiceImpl implements MobStockInService{
	
	private MobstockinDao mobstockinDao;
	private SupTradedetailDao supTradedetailDao;
	private SupStockinsnDao supStockinsnDao;
	private MobstockDao  mobstockDao;
	public void setSupStockinsnDao(SupStockinsnDao supStockinsnDao) {
		this.supStockinsnDao = supStockinsnDao;
	}

	public void setMobstockinDao(MobstockinDao mobstockinDao) {
		this.mobstockinDao = mobstockinDao;
	}

	public void setSupTradedetailDao(SupTradedetailDao supTradedetailDao) {
		this.supTradedetailDao = supTradedetailDao;
	}

	public void setMobstockDao(MobstockDao mobstockDao) {
		this.mobstockDao = mobstockDao;
	}

	//添加入库单
	@SuppressWarnings("unchecked")
	public void addInvoice(Mobstockin msi, SupTradedetail suptradedetail,
			List<Map> snList) {
		mobstockinDao.insertSelective(msi);
		//添加供应商明细
		supTradedetailDao.insertSelective(suptradedetail);
		Iterator it = snList.iterator();
		while (it.hasNext()) {
			Map<String,String> snMap = (Map<String,String>) it.next();
			supStockinsnDao.insertByMap(snMap);
		}
	}
	//获取入库单
	public List<Mobstockin> queryList() {
		// TODO Auto-generated method stub
		return mobstockinDao.queryList();
	}
	//审核入库单
	public void updateCheck(Mobstockin msi, SupTradedetail suptradedetail,
			List<SupStockinsn> mobStockList) {
		mobstockinDao.updateByPrimaryKeySelective(msi);
		supTradedetailDao.updateByPrimaryKeySelective(suptradedetail);
		//int test = 1/0;
		Iterator it = mobStockList.iterator();
		while(it.hasNext()){
			SupStockinsn supStockinsn = (SupStockinsn) it.next();
			Mobstock mobstock = new Mobstock();
			mobstock.setSn1(supStockinsn.getSn1());
			mobstock.setStatus(msi.getStatus());
			System.out.println(mobstock);
			mobstockDao.updateByPrimaryKeySelective(mobstock);
		}
	}

	public List<Mobstockin> findMobStockIn() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Mobstockin> findMobStockIn(Map<String, String> map) {
		// TODO Auto-generated method stub
		return mobstockinDao.findMobStockIn(map);
	}

	//删除入库单
	public void delete(Mobstockin msi) {
		// TODO Auto-generated method stub
		//删除供应商记录
		supTradedetailDao.deleteByPrimaryKey(msi.getInvoiceid());
		
		List<SupStockinsn> snList = new ArrayList<SupStockinsn>();
		//删除库存表数据
		snList = supStockinsnDao.getSupStockinsnByInvoiceId(msi.getInvoiceid());
		Iterator it = snList.iterator();
		while(it.hasNext()){
			SupStockinsn supStockinsn = (SupStockinsn) it.next();
			mobstockDao.deleteByPrimaryKey(supStockinsn.getSn1());
		}
		//删除串号表数据
		supStockinsnDao.deleteByInvoiceid(msi.getInvoiceid());
		
		//删除入库单表的数据
		mobstockinDao.deleteByPrimaryKey(msi.getInvoiceid());
		
	}

	//通过ID获取入库单
	public Mobstockin getmobStockInByid(String invoiceid) {
		// TODO Auto-generated method stub
		return mobstockinDao.selectByPrimaryKey(invoiceid);
	}

	//更新入库单
	public void update(Mobstockin msi, SupTradedetail suptradedetail,
			List<Map> snList) {
		mobstockinDao.updateByPrimaryKeySelective(msi);
		supTradedetailDao.updateByPrimaryKeySelective(suptradedetail);
		supStockinsnDao.deleteByInvoiceid(msi.getInvoiceid());
		Iterator it = snList.iterator();
		while (it.hasNext()) {
			Map<String,String> snMap = (Map<String,String>) it.next();
			
			supStockinsnDao.insertByMap(snMap);
		}
		
	}
}
