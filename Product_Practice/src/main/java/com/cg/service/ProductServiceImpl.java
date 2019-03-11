package com.cg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.beans.Product;
import com.cg.repository.ProductRepository;

@Transactional
@Service("service")
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository repo;	
	public ProductRepository getRepo() {
		return repo;
	}
	public void setRepo(ProductRepository repo) {
		this.repo = repo;
	}
	@Override
	public Product addProduct(Product product) {
		return repo.addProduct(product);
	}
	@Override
	public Product findProduct(int proId) {
		return repo.findProduct(proId);
	}
	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return repo.updateProduct(product);
	}
	@Override
	public List<Product> getProductList() {
		return repo.getProductList();
	}
	@Override
	public Product removeProduct(int proId) {
		// TODO Auto-generated method stub
		return repo.removeProduct(proId);
	}
	@Override
	public int total(int proid) {
		return repo.total(proid);
	}

}
