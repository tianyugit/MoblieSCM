package com.sise.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.sise.dao.CustomerDao;
import com.sise.pojo.Customer;
import com.sise.pojo.JsonBean;

public class CustomerServiceImpl implements CustomerService{
	
	private CustomerDao customerDao;

	public Customer getCustomer(Customer customer) throws SQLException {
		// TODO Auto-generated method stub
		return customerDao.selectByPrimaryKey(customer.getCustid());
	}

	public void addCustomer(Customer customer) throws SQLException {
		// ID×ª´óÐ´
		customer.setCustid(customer.getCustid().toUpperCase());
		customerDao.insert(customer);
	}

	public void editCustomer(Customer customer) throws SQLException {
		// TODO Auto-generated method stub
		customerDao.updateByPrimaryKey(customer);
	}

	public void delCustomer(Customer customer) throws SQLException {
		// TODO Auto-generated method stub
		customerDao.deleteByPrimaryKey(customer.getCustid());
	}

	public List<Customer> getCustomerList(String... strings)
			throws SQLException {
		// TODO Auto-generated method stub
		return customerDao.getCustomerList(strings[0]);
	}

	public List<Customer> findCustomer(Map<String, String> map) {
		// TODO Auto-generated method stub
		return customerDao.findCustomer(map);
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public List<JsonBean> findCust(Map<String, String> map) {
		// TODO Auto-generated method stub
		return customerDao.findCust(map);
	}

	public Customer findCustByName(String custName) {
		// TODO Auto-generated method stub
		return customerDao.findCustByName(custName);
	}

	public List<Customer> queryList() {
		// TODO Auto-generated method stub
		return customerDao.queryList();
	}

	
	
	

}
