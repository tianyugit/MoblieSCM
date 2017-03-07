package com.sise.action;

import java.util.List;

import com.sise.pojo.Customer;
import com.sise.pojo.Customertype;
import com.sise.service.CustomerService;
import com.sise.service.CustomertypeService;

/**
 * ========================================================================
 * 
 * 版本:1.0
 *
 *创建日期:2016年11月17日 上午11:14:59
 *
 *作者:马天宇
 *
 *描述:
 *
 *
 *版权:T世界版权所有(c) 2016
 *
 *==========================================================================
 */
@SuppressWarnings({ "rawtypes" })
public class CustomerTypeManageAction extends BasicAction{
	
	private static final long serialVersionUID = 7691619840724466064L;
	private CustomertypeService customertypeService;
	private CustomerService customerService;
	private Customertype custType;
	private List customerTypeList;
	
	/**
	 * 跳转至列表界面
	 * @return
	 * @throws Exception
	 */
	 public String list() throws Exception {	
		 customerTypeList = customertypeService.getTypeList();
	        return "list";
	    }
	
	 /*
     * 转到添加界面
     */
    public String toAdd() throws Exception {
        return "add";
    }
    /**
     * 向数据库插入添加的类别
     * @return
     * @throws Exception
     */
    public String addType() throws Exception {
        if (customertypeService.addType(custType)) {
        	customerTypeList = customertypeService.getTypeList();
            return "list";
        } else {
            errMap.put("dupTypeId", "供应商编号已存在,请指定其它编号");
            return "add";
        }
    	
    	//return "add";
    }
    /**
     * 转到类别编辑界面
     * @return
     * @throws Exception
     */
    public String toEdit() throws Exception {
    	custType =  customertypeService.getType(custType);
        return "edit";
    }

    public String editType() throws Exception {
        customertypeService.editType(custType);
        customerTypeList = customertypeService.getTypeList();
        return "list";
    }
    /**
     * 删除类别
     * @return
     * @throws Exception
     */
    public String delType() throws Exception {
        
     //   Supplier para = new Supplier();
     //   para.setSupplierType(supplierType);
    	  Customer cust = new Customer();
    	  cust.setCustomerType(custType);
    	 // System.out.println(cust.getCustomerType().getCusttypeid());
    	    if (customerService.getCustomerList(cust.getCustomerType().getCusttypeid()).size() > 0) {
    	  // System.out.println("sgfdgdfgdgdgs");
    	  session.put("message", "OK");
    	  response.sendRedirect("custType_list.do"); 
    	  return null;
        }
        customertypeService.delType(custType);
        customerTypeList = customertypeService.getTypeList();
        return "list";
    }
	public Customertype getCustType() {
		return custType;
	}
	public void setCustType(Customertype custType) {
		this.custType = custType;
	}
	public List getCustomerTypeList() {
		return customerTypeList;
	}
	public void setCustomerTypeList(List customerTypeList) {
		this.customerTypeList = customerTypeList;
	}
	public void setCustomertypeService(CustomertypeService customertypeService) {
		this.customertypeService = customertypeService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
    
	
    
}
