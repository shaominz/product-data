package com.shaomin.microservices.controller;

import java.time.Instant;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDetails {
	private Instant timestamp;
	private String message;
	private String details;
}