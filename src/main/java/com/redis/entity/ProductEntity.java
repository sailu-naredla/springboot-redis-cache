package com.redis.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import com.googlecode.jmapper.annotations.JMap;
import com.redis.cache.Cacheable;

import lombok.Data;

@Data
@RedisHash("Product")
public class ProductEntity implements Serializable, Cacheable {
	
	private static final long serialVersionUID = 1L;

	private static final String OBJECT_KEY = "PRODUCT";
	
	@JMap
	@Id
	String id;
	
	@JMap
	String name;
	
	@JMap
	String price;
	
	@JMap
	String qty;

	@Override
	public String getCacheKey() {
		return id;
	}

	@Override
	public String getObjectKey() {
		return OBJECT_KEY;
	}

}
