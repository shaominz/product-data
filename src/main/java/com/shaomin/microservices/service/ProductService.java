package com.shaomin.microservices.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.shaomin.microservices.domain.Product;

public interface ProductService {
	Optional<Product> getProduct(Long id);
	
	List<Product> getProducts(Collection<Long> ids);

	List<Product> loadAll();
}
