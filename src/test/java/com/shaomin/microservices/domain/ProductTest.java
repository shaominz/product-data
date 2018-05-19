package com.shaomin.microservices.domain;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ProductTest {

	@Test
	public void test() {
		Product product = Product.builder().id(1L).name("product").price(1.23456).build();
		
		assertThat(product.getId(), is(1L));
		assertThat(product.getName(), is("product"));
		assertThat(product.getPrice(), is(1.23456));
	}

}
