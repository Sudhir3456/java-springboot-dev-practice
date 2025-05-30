package com.jspider.spring_boot_simple_crud_with_mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
public class SpringBootSimpleCrudWithMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSimpleCrudWithMysqlApplication.class, args);

		   System.out.println("Welcome Sudhir in SpringBoot....");
	}

}
