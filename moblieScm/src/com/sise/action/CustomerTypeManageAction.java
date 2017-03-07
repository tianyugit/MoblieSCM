package com.sise.action;

import java.util.List;

import com.sise.pojo.Customer;
import com.sise.pojo.Customertype;
import com.sise.service.CustomerService;
import com.sise.service.CustomertypeService;

/**
 * ========================================================================
 * 
 * �汾:1.0
 *
 *��������:2016��11��17�� ����11:14:59
 *
 *����:������
 *
 *����:
 *
 *
 *��Ȩ:T�����Ȩ����(c) 2016
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
	 * ��ת���б����
	 * @return
	 * @throws Exception
	 */
	 public String list() throws Exception {	
		 customerTypeList = customertypeService.getTypeList();
	        return "list";
	    }
	
	 /*
     * ת����ӽ���
     */
    public String toAdd() throws Exception {
        return "add";
    }
    /**
     * �����ݿ������ӵ����
     * @return
     * @throws Exception
     */
    public String addType() throws Exception {
        if (customertypeService.addType(custType)) {
        	customerTypeList = customertypeService.getTypeList();
            return "list";
        } else {
            errMap.put("dupTypeId", "��Ӧ�̱���Ѵ���,��ָ���������");
            return "add";
        }
    	
    	//return "add";
    }
    /**
     * ת�����༭����
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
     * ɾ�����
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
