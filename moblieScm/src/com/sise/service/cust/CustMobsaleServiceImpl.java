package com.sise.service.cust;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.sise.dao.cust.CustMobsaleDao;
import com.sise.dao.cust.CustMobsalesnDao;
import com.sise.dao.cust.CustTradedetailDao;
import com.sise.dao.sup.MobstockDao;
import com.sise.pojo.CustMobsale;
import com.sise.pojo.CustMobsalesn;
import com.sise.pojo.CustTradedetail;
import com.sise.pojo.Mobstock;

public class CustMobsaleServiceImpl implements CustMobsaleService{
	
	 private CustMobsaleDao custMobsaleDao;
	 private CustMobsalesnDao custMobsalesnDao;
	 private CustTradedetailDao custTradedetailDao;
	 private MobstockDao mobstockDao;

	 //添加销售单
	public void add(CustMobsale mobReturn, CustTradedetail custtradedetail,
			List<Map> snList) throws Exception {
		//数据库插入
		custMobsaleDao.insertSelective(mobReturn);
		custTradedetailDao.insertSelective(custtradedetail);
		Iterator it = snList.iterator();
		while (it.hasNext()) {
			//遍历销售的手机串号
			Map<String,String> snMap = (Map<String,String>) it.next();
			Mobstock mobstock = new Mobstock();
			CustMobsalesn custMobsalesn = new CustMobsalesn();
			mobstock = mobstockDao.selectByPrimaryKey(snMap.get("sn1"));
			
			BeanUtils.copyProperties(custMobsalesn, mobstock);
			custMobsalesn.setInvoiceid(snMap.get("invoiceid"));
			custMobsalesnDao.insertSelective(custMobsalesn);
		}
		
	}
	//审核销售单
	public void updateCheck(CustMobsale mobSale,
			CustTradedetail custtradedetail,
			List<CustMobsalesn> custMobsalesnList) {
		
			custMobsaleDao.updateByPrimaryKeySelective(mobSale);
			custTradedetailDao.updateByPrimaryKeySelective(custtradedetail);
	//int test = 1/0;
	Iterator it = custMobsalesnList.iterator();
	while(it.hasNext()){
		CustMobsalesn custMobsalesn = (CustMobsalesn) it.next();
		/*Mobstock mobstock = new Mobstock();
		mobstock.setSn1(supStockinsn.getSn1());*/
		//mobstock.setStatus(mobreturn.getStatus());
		//System.out.println(mobstock);
		mobstockDao.deleteByPrimaryKey(custMobsalesn.getSn1());
		
	}
	}
	//获取销售单列表
	public List<CustMobsale> getList(String string) {
		// TODO Auto-generated method stub
		return custMobsaleDao.getList(string);
	}
	
	//删除销售单
	public void delete(CustMobsale mobSale) {
		List<CustMobsalesn> snList= custMobsalesnDao.getSnByInvoiceid(mobSale);
		Iterator it = snList.iterator();
		while(it.hasNext()){
			CustMobsalesn custMobsalesn = (CustMobsalesn) it.next();
			/*Mobstock mobstock = new Mobstock();
			mobstock.setSn1(supStockinsn.getSn1());*/
			//mobstock.setStatus(mobreturn.getStatus());
			//System.out.println(mobstock);
			custMobsalesnDao.deleteByPrimaryKey(custMobsalesn.getSn1());
			
		}
		custMobsaleDao.deleteByPrimaryKey(mobSale.getInvoiceid());
		custTradedetailDao.deleteByPrimaryKey(mobSale.getInvoiceid());
	}
	public void setCustMobsaleDao(CustMobsaleDao custMobsaleDao) {
		this.custMobsaleDao = custMobsaleDao;
	}

	public void setCustMobsalesnDao(CustMobsalesnDao custMobsalesnDao) {
		this.custMobsalesnDao = custMobsalesnDao;
	}

	public void setCustTradedetailDao(CustTradedetailDao custTradedetailDao) {
		this.custTradedetailDao = custTradedetailDao;
	}

	public void setMobstockDao(MobstockDao mobstockDao) {
		this.mobstockDao = mobstockDao;
	}

	

}
