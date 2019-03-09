package com.cg.mpt.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mpt.beans.Customer;
import com.cg.mpt.repository.CustomerRepository;

@Transactional
@Service("service")
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository repo;	
	public CustomerRepository getRepo() {
		return repo;
	}
	public void setRepo(CustomerRepository repo) {
		this.repo = repo;
	}
	@Override
	public Customer addCustomer(Customer customer) {
		return repo.addCustomer(customer);
	}
	@Override
	public Customer findCustomer(int customerid) {
		return repo.findCustomer(customerid);
	}
	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return repo.updateCustomer(customer);
	}
	@Override
	public List<Customer> getCustomerList() {
		return repo.getCustomerList();
	}
	@Override
	public Customer removeCustomer(int custid) {
		// TODO Auto-generated method stub
		return repo.removeCustomer(custid);
	}

}
