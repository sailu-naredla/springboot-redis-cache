package com.redis.dto;

import java.util.List;

import lombok.Data;

@Data
public class ProductRequest {

	private List<Product> products;
}
