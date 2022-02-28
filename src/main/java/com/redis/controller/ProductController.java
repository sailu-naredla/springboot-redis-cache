package com.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.dto.Product;
import com.redis.dto.ProductRequest;
import com.redis.service.ProductService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public boolean saveProduct(@RequestBody ProductRequest productRequest) {
		log.info("Entering saveProduct");
		boolean response = productService.saveProduct(productRequest);
		log.info("Exiting saveProduct");
		return response;
	}
	
	 @GetMapping("/{id}")
	 public Product getProduct(@PathVariable("id") String productId) {
		log.info("Entering getProduct");
		Product response = productService.getProduct(productId);
		log.info("Exiting getProduct");
		return response;
	}

}
