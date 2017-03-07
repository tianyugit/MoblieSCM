package com.sise.service;

import java.util.List;
import java.util.Map;

import com.sise.dao.AccessorytypeDao;
import com.sise.pojo.Accessorytype;
import com.sise.pojo.SupplierType;

public class AccessoryTypeServiceImpl implements AccessoryTypeService{
	
	private AccessorytypeDao accessorytypeDao;

	public boolean addType(Accessorytype accessorytype) throws Exception {
		 if (accessorytypeDao.selectByPrimaryKey(accessorytype.getAccessorytypeid()) != null) {
	           return false;
	        }
	        // 将编号改为大写字母
		 accessorytype.setAccessorytypeid(accessorytype.getAccessorytypeid()
	                .toUpperCase());
	         
	        if( accessorytypeDao.insert(accessorytype) == 1)
	        	return true;
	        else
	        	return false;
	}
	
	public Accessorytype getType(Accessorytype accessorytype) throws Exception {
		// TODO Auto-generated method stub
		return accessorytypeDao.selectByPrimaryKey(accessorytype.getAccessorytypeid());
	}
	public void editType(Accessorytype accessorytype) throws Exception {
		accessorytypeDao.updateByPrimaryKey(accessorytype);
	}

	public void delType(Accessorytype accessorytype) throws Exception {
		// TODO Auto-generated method stub
		accessorytypeDao.deleteByPrimaryKey(accessorytype.getAccessorytypeid());
	}
	public List<Accessorytype> findAccessoryType(Map<String, String> map) {
			
		return accessorytypeDao.findAccessoryType(map);
	}
	
	public List<Accessorytype> getTypeList() {
		
		return accessorytypeDao.getTypeList();
	}

	public void setAccessorytypeDao(AccessorytypeDao accessorytypeDao) {
		this.accessorytypeDao = accessorytypeDao;
	}

	public List<Accessorytype> findAccTypeByBrand(String brand) {
		
		return accessorytypeDao.findAccTypeByBrand(brand);
	}

	public List<Accessorytype> findaccTypeByselected(Map<String, String> map) {
		// TODO Auto-generated method stub
		return accessorytypeDao.findaccTypeByselected(map);
	}

	



}
