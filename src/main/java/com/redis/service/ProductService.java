package com.redis.service;

import com.redis.dto.Product;
import com.redis.dto.ProductRequest;

public interface ProductService {

	public boolean saveProduct(ProductRequest productRequest);
	
	public Product getProduct(String productId);
	
}
