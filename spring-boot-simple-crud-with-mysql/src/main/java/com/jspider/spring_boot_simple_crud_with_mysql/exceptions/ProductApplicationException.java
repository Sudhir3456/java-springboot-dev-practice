package com.jspider.spring_boot_simple_crud_with_mysql.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jspider.spring_boot_simple_crud_with_mysql.responses.ResponseStructure;

@ControllerAdvice
public class ProductApplicationException {

	@Autowired
	ResponseStructure<String> structure;

	@ExceptionHandler(value = IdNotFoundExceception.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptions(IdNotFoundExceception exceception) {

		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setApiDescription(exceception.getMessage());
		structure.setData(null);

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatusCode.valueOf(404));

	}

}
