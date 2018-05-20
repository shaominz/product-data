package com.shaomin.microservices.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shaomin.microservices.domain.Product;
import com.shaomin.microservices.domain.ProductNotFoundException;
import com.shaomin.microservices.service.ProductService;

@RestController
@RequestMapping(value = "/product-data/products")
public class ProductServiceController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("id") Long productId) {
		return productService.getProduct(productId).orElseThrow(
				() -> new ProductNotFoundException(String.format("Product not found for id: %s", productId)));
	}

	@RequestMapping(value = "/string/{id}", method = RequestMethod.GET)
	public String getProductString(@PathVariable("id") Long productId) {
		return productService.getProduct(productId)
				.map(p -> String.format("%s|%s|%s", p.getId(), p.getName(), p.getPrice()))
				.orElseThrow(() -> new ProductNotFoundException(String.format("Product not found for id: %s", productId)));
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Product> getProducts(@RequestParam("ids") long[] ids) {
		//http://localhost:8080/product-data/products?ids=1,2
		List<Long> lids = Arrays.stream(ids).boxed().collect(Collectors.toList());
		return productService.getProducts(lids);
	}

	 @RequestMapping(value = "/all", method = RequestMethod.GET)
	 public List<Product> getAllProducts() {
	 return productService.loadAll();
	 }
}
