package com.sise.service;

import java.util.List;

import com.sise.pojo.Supplier;
import com.sise.pojo.SupplierType;


public interface SupplierTypeService {

    boolean addType(SupplierType supplierType) throws Exception;

    SupplierType getType(SupplierType supplierType) throws Exception;

    void editType(SupplierType supplierType) throws Exception;

    void delType(SupplierType supplierType) throws Exception;

	List<SupplierType> getTypeList();

}
