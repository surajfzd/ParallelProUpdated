package com.cg.mpt.SpringBootJPAIntegrationvansh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.mpt.beans.Customer;
import com.cg.mpt.service.CustomerService;


@RestController
public class MyRestController {
	
	 @Autowired
	CustomerService service;
	
	
	public CustomerService getService() {
		return service;
	}


	public void setService(CustomerService service) {
		this.service = service;
	}


	@RequestMapping(value="/addCustomer",consumes="application/json",
			method=RequestMethod.POST,produces="application/json")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		
		customer= service.addCustomer(customer);
		return customer;
	}
	
	@RequestMapping(value="/findCustomer/{customerId}",produces="application/json")
	public Customer findCustomer(@PathVariable int customerId)
	{
		Customer customer=service.findCustomer(customerId);
		return customer;
	}

	@RequestMapping(value="/updateCustomer/{customerId}",consumes="application/json",
			produces="application/json",method=RequestMethod.PUT)
	public Customer updateCustomer(@RequestBody Customer customer)
	{
		
		customer=service.updateCustomer(customer);
		return customer;
	}
	
	
	@RequestMapping(value="/removeCustomer/{customerId}",consumes="application/json",
			method=RequestMethod.POST,produces="application/json")
	public Customer removeCustomer(@PathVariable int customerId)
	{
		Customer customer=service.removeCustomer(customerId);
		return customer;
	}
	
	@RequestMapping(value="getCustomerList",produces="application/json")
	public List<Customer> getCustomerList()
	{
		List<Customer> list =service.getCustomerList();
		return list;
	}
	
	
	
}






