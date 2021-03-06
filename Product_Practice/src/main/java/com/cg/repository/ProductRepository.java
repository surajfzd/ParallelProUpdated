package com.cg.repository;

import java.util.List;

import com.cg.beans.Product;

public interface ProductRepository {

	public Product addProduct(Product product);
	public Product findProduct(int proid);
	public Product updateProduct(Product product);
	public List<Product> getProductList();
    public Product removeProduct(int proid);
    public int total(int proid);
    
}
