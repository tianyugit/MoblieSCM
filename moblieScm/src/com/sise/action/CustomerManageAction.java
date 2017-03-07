package com.sise.action;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sise.dao.CustomerDao;
import com.sise.pojo.Customer;
import com.sise.pojo.Customertype;
import com.sise.pojo.Pagination;
import com.sise.service.CustomerService;
import com.sise.service.CustomertypeService;

/**
 * ========================================================================
 * 
 * �汾:1.0
 *
 *��������:2016��11��17�� ����11:14:43
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
public class CustomerManageAction extends BasicAction{
	
	private static final long serialVersionUID = -3241677377308799470L;
	private Customer customer;
	private Customertype custType;
	private List<Customertype> customerTypeList;
    private List<Customer> CustomerList;
    private CustomerDao customerDao;
    private CustomertypeService customertypeService;
    private CustomerService customerService;
	
	 /**
     * ��ѯ�ͻ��������б�ҳ
     * 
     * @return
     * @throws Exception
     */
    public String list() throws Exception {
    	
        //customerTypeList = CustomerTypeService.getType(null);
        //paginatedQuery("Customer.getCustomer");
    	
    	Map map = new HashMap();	
	    pagination = new Pagination();
		int pageLong = customerDao.getPageLong();
		
		pagination.setPageIndex(pageIndex== null ? 1 : pageIndex );
		pagination.setPageSize(15);
		pagination.setTotalRecordCnt(pageLong);
		pagination.setUrl("custSale_list.do?");
		CustomerList = customerDao.findAllWithFy(map,((pageIndex== null ? 1 : pageIndex) - 1) * 15, 15);
		pagination.setDataList(CustomerList);
    	//System.out.println("dfdfdf" + CustomerList);
    	customerTypeList = customertypeService.getTypeList();
    	//getLists(null);
    	
        return "list";
    }

	private void getLists(Customer customer) {
	//	CustomerList = customerService.queryList();
		Map map = new HashMap();
		if(customer != null){
		map.put("custtypeid", "%" + customer.getCustomerType().getCusttypeid() + "%");
    	map.put("custname", "%" + customer.getCustname() + "%");
		}
	    pagination = new Pagination();
		int pageLong = customerDao.getPageLong();
		
		pagination.setPageIndex(pageIndex== null ? 1 : pageIndex );
		pagination.setPageSize(15);
		pagination.setTotalRecordCnt(pageLong);
		pagination.setUrl("custSale_list.do?");
		CustomerList = customerDao.findAllWithFy(map,((pageIndex== null ? 1 : pageIndex) - 1) * 15, 15);
		pagination.setDataList(CustomerList);
    	//System.out.println("dfdfdf" + CustomerList);
    	customerTypeList = customertypeService.getTypeList();
	}

    /**
     * ת������ҳ
     * 
     * @return
     * @throws Exception
     */
    public String toAdd() throws Exception {
        customerTypeList = customertypeService.getTypeList();
        System.out.println(customerTypeList);
        return "add";
    }

    /**
     * �����ͻ�
     * 
     * @return
     * @throws Exception
     */
    public String addCustomer() throws Exception {
    	/*  if (CustomerTypeService.addType(CustomerType)) {
          	customerTypeList = CustomerTypeService.getTypeList();
              return "list";
          } else {
              errMap.put("typeId", "�ͻ�����Ѵ���,��ָ���������");
              return "add";
          }*/
        // ID�Ƿ��ظ�
       // Customer para = new Customer();
      //  para.setSupid(Customer.getSupid());
        Customer cust = new Customer();
        cust.setCustid(customer.getCustid());
        if (customerService.getCustomer(cust) != null ) {
            customerTypeList = customertypeService.getTypeList();
            errMap.put("CustomerId", "�������Ѵ���");
            return "add";
        }
        System.out.println(customer);
        customerService.addCustomer(customer);
        getLists(null);
        return "list";
    }

    /**
     * ת���༭ҳ
     * 
     * @return
     * @throws Exception
     */
    public String toEdit() throws Exception {
    	customer = customerService.getCustomer(customer);
        customerTypeList = customertypeService.getTypeList();
        return "edit";
    }

    /**
     * �޸Ŀͻ�
     * 
     * @return
     * @throws Exception
     */
    public String editCustomer() throws Exception {
        customerService.editCustomer(customer);
        getLists(null);
        return "list";
    }

    /**
     * ɾ���ͻ�
     * 
     * @return
     * @throws Exception
     */
    
    public String delCustomer() throws Exception {
        customerService.delCustomer(customer);
        
        getLists(null);
        return "list";
    }
    
    public String findCustomer() throws Exception{
    	//System.out.println("dfsdsdfggg"+CustomerType.getSuptypeid());
    	request.getAttribute("");
    	//CustomerType = CustomerTypeService.getType(CustomerType);
    	Map<String,String> map = new LinkedHashMap<String,String>();
    	map.put("custtypeid", "%" + customer.getCustomerType().getCusttypeid() + "%");
    	map.put("custname", "%" + customer.getCustname() + "%");
    	System.out.println(map);
    	 CustomerList = customerService.findCustomer(map);
    	//getLists(customer);
    	 customerTypeList = customertypeService.getTypeList();
    	return "list";
    }

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Customertype getCustType() {
		return custType;
	}

	public void setCustType(Customertype custType) {
		this.custType = custType;
	}

	public List<Customertype> getCustomerTypeList() {
		return customerTypeList;
	}

	public void setCustomerTypeList(List<Customertype> customerTypeList) {
		this.customerTypeList = customerTypeList;
	}

	public List<Customer> getCustomerList() {
		return CustomerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		CustomerList = customerList;
	}

	public void setCustomertypeService(CustomertypeService customertypeService) {
		this.customertypeService = customertypeService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

}
