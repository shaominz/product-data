package com.shaomin.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shaomin.microservices.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
