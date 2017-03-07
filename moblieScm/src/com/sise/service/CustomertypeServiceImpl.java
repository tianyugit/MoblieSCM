package com.sise.service;

import java.util.List;

import com.sise.dao.CustomertypeDao;
import com.sise.pojo.Customertype;
import com.sise.pojo.SupplierType;

public class CustomertypeServiceImpl implements CustomertypeService{
	
	private CustomertypeDao customertypeDao;

	public boolean addType(Customertype customertype) throws Exception {
		 if (customertypeDao.selectByPrimaryKey(customertype.getCusttypeid()) != null) {
	           return false;
	        }
	        // 将编号改为大写字母
		 customertype.setCusttypeid(customertype.getCusttypeid()
	                .toUpperCase());
	         
	        if(customertypeDao.insert(customertype) == 1)
	        	return true;
	        else
	        	return false;
	}

	public Customertype getType(Customertype customertype) throws Exception {
		// TODO Auto-generated method stub
		return customertypeDao.selectByPrimaryKey(customertype.getCusttypeid());
	}

	public void editType(Customertype customertype) throws Exception {
		customertypeDao.updateByPrimaryKey(customertype);
		
	}

	public void delType(Customertype customertype) throws Exception {
		customertypeDao.deleteByPrimaryKey(customertype.getCusttypeid());
		
	}

	public List<Customertype> getTypeList() {
		
		return customertypeDao.getTypeList();
	}

	public void setCustomertypeDao(CustomertypeDao customertypeDao) {
		this.customertypeDao = customertypeDao;
	}

	
	
}
