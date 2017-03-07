package com.sise.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.sise.pojo.Supplier;


public interface SupplierService {

    Supplier getSupplier(Supplier supplier) throws SQLException;

    void addSupplier(Supplier supplier) throws SQLException;

    void editSupplier(Supplier supplier) throws SQLException;

    void delSupplier(Supplier supplier) throws SQLException;

    public List<Supplier> getSupplierList(String... strings) throws SQLException;

	List<Supplier> findSupplier(Map<String, String> map);

	List<Supplier> findSupplierAjax(Map<String, String> map);

	List getSupplierList2(String suptypeid);
}
