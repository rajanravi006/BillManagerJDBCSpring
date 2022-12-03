package com.spring.bill.dao;

import org.springframework.stereotype.Component;

import com.spring.bill.entity.Products;

@Component
public interface ProductsDao {
	
	public Products getData(String productId);
}
