package com.sise.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.sise.pojo.Customer;
import com.sise.pojo.JsonBean;

public interface CustomerService {

	Customer getCustomer(Customer customer) throws SQLException;

    void addCustomer(Customer customer) throws SQLException;

    void editCustomer(Customer customer) throws SQLException;

    void delCustomer(Customer customer) throws SQLException;

    public List<Customer> getCustomerList(String... strings) throws SQLException;

	List<Customer> findCustomer(Map<String, String> map);

	List<JsonBean> findCust(Map<String, String> map);

	Customer findCustByName(String custName);

	List<Customer> queryList();
}
