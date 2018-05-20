package com.shaomin.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.shaomin.microservices.domain.Product;
import com.shaomin.microservices.repository.ProductRepository;

@SpringBootApplication
public class ProductDataApplication {

	public static void main(String[] args) {
		// SpringApplication.run(ProductDataApplication.class, args);

		ConfigurableApplicationContext context = SpringApplication.run(ProductDataApplication.class, args);

		ProductRepository productRepository = context.getBean(ProductRepository.class);
		productRepository.save(Product.builder().id(1L).name("product1").price(1.2345).build());
		productRepository.save(Product.builder().id(2L).name("product2").price(2.3456).build());
		productRepository.save(Product.builder().id(3L).name("product3").price(3.4567).build());
		productRepository.save(Product.builder().id(4L).name("product4").price(4.5687).build());
		
		ServiceConfig s = context.getBean(ServiceConfig.class);
		System.out.println("aaaaaaaaaaaaaaaaaaaaa: " + s.getEnvironment());
	}
}
