package com.cg.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.beans.Product;

@Repository("repo")
public class ProductRepositoryImpl implements ProductRepository{
	
	@PersistenceContext
	EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Override
	public Product addProduct(Product product) {
		
		entityManager.persist(product);
		entityManager.flush();
		return product;
	}
	@Override
	public Product findProduct(int proid) {
		Product product= 
				entityManager.find(Product.class, proid);
		if(product==null)
			return null;
		product.setProId(proid);
		return product;
	}
	@Override
	public Product updateProduct(Product product) {
		entityManager.merge(product);
		entityManager.flush();
		return product;
	}
	@Override
	public List<Product> getProductList() {
		TypedQuery<Product> query=
	entityManager.createQuery
	("select product from Product product ", Product.class);
			
		List<Product> list= query.getResultList();
	return list;
	}
	@Override
	public Product removeProduct(int proid) {
		Product product= entityManager.find(Product.class, proid);
		entityManager.remove(product);
		entityManager.flush();
		return product;
	}
	@Override
	public int total(int proid) {
		Product product=entityManager.find(Product.class, proid);
		int amt=product.getPrice();
		int quantity=product.getQty();
		int sum=amt*quantity;
		return sum;
	}


}
