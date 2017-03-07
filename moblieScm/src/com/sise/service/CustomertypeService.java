package com.sise.service;

import java.util.List;

import com.sise.pojo.Customertype;
import com.sise.pojo.SupplierType;


public interface CustomertypeService {

    boolean addType(Customertype customertype) throws Exception;

    Customertype getType(Customertype customertype) throws Exception;

    void editType(Customertype customertype) throws Exception;

    void delType(Customertype customertype) throws Exception;

	List<Customertype> getTypeList();

}
