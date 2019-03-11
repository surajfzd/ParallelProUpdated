package com.cg.mpt.SpringBootJPAIntegrationvansh.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.beans.Product;
import com.cg.service.ProductService;


@RestController
public class MyRestController {
	
	 @Autowired
	ProductService service;
	
	
	public ProductService getService() {
		return service;
	}


	public void setService(ProductService service) {
		this.service = service;
	}


	@RequestMapping(value="/addProduct",consumes="application/json",
			method=RequestMethod.POST,produces="application/json")
	public Product addProduct(@RequestBody Product product)
	{
		
		product= service.addProduct(product);
		return product;
	}
	
	@RequestMapping(value="/findProduct/{proId}",produces="application/json")
	public Product findProduct(@PathVariable int proId)
	{
		Product product=service.findProduct(proId);
		return product;
	}

	@RequestMapping(value="/updateProduct/{proId}",consumes="application/json",
			produces="application/json",method=RequestMethod.POST)
	public Product updateProduct(@RequestBody Product product)
	{
		
		product=service.updateProduct(product);
		return product;
	}
	
	
	@RequestMapping(value="/removeProduct/{proId}",consumes="application/json",
			method=RequestMethod.POST,produces="application/json")
	public Product removeProduct(@PathVariable int proId)
	{
		Product product=service.removeProduct(proId);
		return product;
	}
	
	@RequestMapping(value="getProductList",produces="application/json")
	public List<Product> getProductList()
	{
		List<Product> list =service.getProductList();
		return list;
	}
	
	@RequestMapping(value="/total/{proid}",produces="application/json")
	public int total(@PathVariable int proid)
	{
		int cal=service.total(proid);
		return cal;
	}
	
}






