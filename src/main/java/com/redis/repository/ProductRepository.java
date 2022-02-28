package com.redis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.redis.entity.ProductEntity;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, String> {

}
