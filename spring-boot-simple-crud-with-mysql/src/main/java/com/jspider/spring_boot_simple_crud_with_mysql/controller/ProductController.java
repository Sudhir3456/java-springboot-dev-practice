package com.jspider.spring_boot_simple_crud_with_mysql.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.spring_boot_simple_crud_with_mysql.dao.ProductDao;
import com.jspider.spring_boot_simple_crud_with_mysql.enity.Product;
import com.jspider.spring_boot_simple_crud_with_mysql.exceptions.IdNotFoundExceception;
import com.jspider.spring_boot_simple_crud_with_mysql.responses.ResponseStructure;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	ProductDao dao;

	@Autowired
	ResponseStructure<Product> responseStructure;

	@GetMapping(value = "/getTodayDate")
	public String getTodayDate() {

		return LocalDate.now() + " ";

	}

	@PostMapping(value = "/saveProduct")
	public Product saveProductController(@RequestBody Product product) {

		System.out.println(product);
		Product product2 = dao.saveProductDao(product);

		return product2;

	}

	@GetMapping(value = "/findAllProducts")
	public List<Product> findAllProductDao() {

		List<Product> product2 = dao.findAllProductDao();

		return product2;

	}

	@GetMapping(value = "/findProductById/{id}")
	public ResponseStructure<Product> findProductByIdDao(@PathVariable(name = "id") Integer id) {

		Product product2 = dao.findProductById(id);

		if (product2 != null) {

			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setApiDescription("get product by id api");
			responseStructure.setData(product2);
			return responseStructure;

		} else {

			throw new IdNotFoundExceception("Given Product id is not found ");

		}
	}

	@GetMapping(value = "/findAllProductByName/{name}")
	public List<Product> findProductByNameDao(@PathVariable String name) {

		List<Product> product2 = dao.findAllProductNameDao(name);

		return product2;

	}

	@GetMapping(value = "/findAllProductByColor/{color}")
	public List<Product> findProductByColorDao(@PathVariable String color) {

		List<Product> product2 = dao.findAllProductColorDao(color);

		return product2;

	}

	// jpql
	@GetMapping(value = "/getAllProductByColor/{color}")
	public List<Product> getProductByColorDao(@PathVariable String color) {

		List<Product> product2 = dao.getAllProductColorDao(color);

		return product2;

	}

	@GetMapping(value = "/findAllProductByPrice/{price}")
	public List<Product> findProductByColorDao(@PathVariable(name = "price") double price) {

		List<Product> product2 = dao.findAllProductByPriceDao(price);

		return product2;

	}

	@GetMapping(value = "/getAllProductByPrice/{price}")
	public List<Product> getProductByPrice(@PathVariable(name = "price") double price) {
		List<Product> product2 = dao.getAllProductByPriceDao(price);

		return product2;

	}

	@DeleteMapping(value = "/deleteProductByPrice/{price}")
	public void deleteProductByPrice(@PathVariable(name = "price") double price) {

		dao.deleteProductByPrice(price);
	}

	@GetMapping(value = "/fatchProductByPageNumber/{initialPage}/{pageSize}")
	public Page<Product> getProductByPageNumber(@PathVariable(name = "initialPage") int initialPage, int pageSize) {

		return dao.getProductByPageNumberDao(initialPage, pageSize);
	}

}
