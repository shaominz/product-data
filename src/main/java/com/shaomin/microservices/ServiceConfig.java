package com.shaomin.microservices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfig {
	
	@Value("${environment}")
	private String environment;

	public String getEnvironment() {
		return environment;
	}
}
