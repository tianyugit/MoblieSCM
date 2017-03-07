package com.sise.service;

import java.util.List;


import com.sise.dao.SupplierTypeDao;
import com.sise.pojo.SupplierType;

public class SupplierTypeServiceImpl implements SupplierTypeService {

	private SupplierTypeDao supplierTypeDao;

    public boolean addType(SupplierType supplierType) throws Exception {

        // 验证相同编号是否已经存在
       // Map<String, Object> paraMap = new HashMap<String, Object>();
       // paraMap.put("supplierType", supplierType);
        if (supplierTypeDao.selectByPrimaryKey(supplierType.getSuptypeid()) != null) {
           return false;
        }
        // 将编号改为大写字母
         supplierType.setSuptypeid(supplierType.getSuptypeid()
                .toUpperCase());
         
        if( supplierTypeDao.insert(supplierType) == 1)
        	return true;
        else
        	return false;
    }

    public SupplierType getType(SupplierType supplierType) throws Exception {
    	
        return supplierTypeDao.selectByPrimaryKey(supplierType.getSuptypeid());
    }

    public void editType(SupplierType supplierType) throws Exception {
    	supplierTypeDao.updateByPrimaryKey(supplierType);
    }

    public void delType(SupplierType supplierType) throws Exception {
    	supplierTypeDao.deleteByPrimaryKey(supplierType.getSuptypeid());
    }

	public void setSupplierTypeDao(SupplierTypeDao supplierTypeDao) {
		this.supplierTypeDao = supplierTypeDao;
	}

	public List<SupplierType> getTypeList() {
		
		return supplierTypeDao.getTypeList();
	}

 

}
