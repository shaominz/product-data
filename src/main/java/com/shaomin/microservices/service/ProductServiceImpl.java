package com.shaomin.microservices.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaomin.microservices.domain.Product;
import com.shaomin.microservices.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Optional<Product> getProduct(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public List<Product> getProducts(Collection<Long> ids) {
		return productRepository.findAllById(ids);
	}

	@Override
	public List<Product> loadAll() {
		return productRepository.findAll();
	}

}
