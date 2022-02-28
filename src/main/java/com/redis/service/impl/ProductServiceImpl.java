package com.redis.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.googlecode.jmapper.JMapper;
import com.redis.cache.CacheService;
import com.redis.dto.Product;
import com.redis.dto.ProductRequest;
import com.redis.entity.ProductEntity;
import com.redis.repository.ProductRepository;
import com.redis.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CacheService<ProductEntity> productCacheService;
	
	@Override
	public boolean saveProduct(ProductRequest productRequest) {
		
		log.info("Entering saveProduct");
		try {
			List<ProductEntity> productEntities = convertProductsToEntities(productRequest.getProducts());
			int count = CollectionUtils.isEmpty(productEntities) ? 0 : productEntities.size();
			if(count > 0) {
				//Option-1 save using repository
				//productRepository.saveAll(productEntities);
				//Option-2 save using redisTemplate
				productCacheService.save(productEntities.get(0));
			}
			return true;
		}catch (Exception e) {
			log.info("Error while conevrting/saving Product");
			e.printStackTrace();
		}
		log.info("Exiting saveProduct");
		
		return false;
	}
	
	private List<ProductEntity> convertProductsToEntities(List<Product> products) {
		
		log.info("Entering convertProductsToEntity");
		JMapper<ProductEntity, Product> mapper = new JMapper<>(ProductEntity.class, Product.class);
		List<ProductEntity> result = products.stream().map(temp -> mapper.getDestination(temp)).collect(Collectors.toList());
		log.info("Exiting convertProductsToEntity");
		
		return result;
	}

	@Override
	public Product getProduct(String productId) {
		
		log.info("Entering getProduct");
		Optional<ProductEntity> productEntity = productRepository.findById(productId);
		Product product = new Product();
		if(productEntity.isPresent()) {
			product.setId(productEntity.get().getId());
			product.setName(productEntity.get().getName());
			product.setPrice(productEntity.get().getPrice());
			product.setQty(productEntity.get().getQty());
		}
		log.info("Exiting getProduct");
		
		return product;
	}
	
	
}
