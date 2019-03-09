package com.cg.mpt.service;

import java.util.List;
import com.cg.mpt.beans.Customer;

public interface CustomerService {


	public Customer addCustomer(Customer customer);
	public Customer findCustomer(int customerid);
	public Customer updateCustomer(Customer customer);
	public List<Customer> getCustomerList();
	public Customer removeCustomer(int custid);
}
