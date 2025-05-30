package com.jspider.spring_boot_simple_crud_with_mysql.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@GetMapping(value = "/getTodayDate")
	public String getTodayDate() {

		return LocalDate.now() + " ";

	}

	@RequestMapping(value = "/addtion/{a1}/{b}", method = RequestMethod.POST)
	public int getAdditionsOfTwoNumber(@PathVariable(name = "a1") int a, @PathVariable(name = "b") int b) {

		return a + b;

	}

}
