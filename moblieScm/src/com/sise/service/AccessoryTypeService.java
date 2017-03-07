package com.sise.service;

import java.util.List;
import java.util.Map;

import com.sise.pojo.Accessorytype;
import com.sise.pojo.Supplier;
import com.sise.pojo.SupplierType;


public interface AccessoryTypeService {

    boolean addType(Accessorytype accessorytype) throws Exception;

    Accessorytype getType(Accessorytype accessorytype) throws Exception;

    void editType(Accessorytype accessorytype) throws Exception;

    void delType(Accessorytype accessorytype) throws Exception;

	List<Accessorytype> getTypeList();

	List<Accessorytype> findAccessoryType(Map<String, String> map);

	List<Accessorytype> findAccTypeByBrand(String brand);

	List<Accessorytype> findaccTypeByselected(Map<String, String> map);

}
