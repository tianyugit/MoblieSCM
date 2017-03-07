package com.sise.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sise.dao.SupplierDao;
import com.sise.pojo.Supplier;


public class SupplierServiceImpl implements SupplierService {

    private SupplierDao supplierDao;

    public void addSupplier(Supplier supplier) throws SQLException {

        // ID转大写
        supplier.setSupid(supplier.getSupid().toUpperCase());
       // dao.addObj("supplier.addSupplier", supplier);
        supplierDao.insert(supplier);
    }

    public Supplier getSupplier(Supplier supplier) throws SQLException {
       /* Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("supplier", supplier);*/
    	//supplierDao.getSupplierList();
      //  return dao.queryList("supplier.getSupplier", paraMap);
        return supplierDao.selectByPrimaryKey(supplier.getSupid());
    }

    public void editSupplier(Supplier supplier) throws SQLException {
    	supplierDao.updateByPrimaryKey(supplier);       
    }

    public void delSupplier(Supplier supplier) throws SQLException {
    //  dao.del("supplier.del", supplier);
    	supplierDao.deleteByPrimaryKey(supplier.getSupid());
    }
    
    public List<Supplier> getSupplierList(String... strings) throws SQLException {
    	//System.out.println(strings[0]);
    	return supplierDao.getSupplierList(strings[0]);
    }

	public void setSupplierDao(SupplierDao supplierDao) {
		this.supplierDao = supplierDao;
	}

	public List<Supplier> findSupplier(Map<String, String> map) {
		
		return supplierDao.findSupplier(map);
	}

	public List<Supplier> findSupplierAjax(Map<String, String> map) {
		// TODO Auto-generated method stub
		return supplierDao.findSupplierAjax(map);
	}

	public List getSupplierList2(String suptypeid) {
		// TODO Auto-generated method stub
		return supplierDao.getSupplierList2(suptypeid);
	}
	

}
