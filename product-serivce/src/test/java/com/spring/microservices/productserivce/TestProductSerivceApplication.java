package com.spring.microservices.productserivce;

import org.springframework.boot.SpringApplication;

public class TestProductSerivceApplication {

	public static void main(String[] args) {
		SpringApplication.from(ProductSerivceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
