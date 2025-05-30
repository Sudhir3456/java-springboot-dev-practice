package com.jspider.spring_boot_simple_crud_with_mysql.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.ScrollPosition.Direction;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.jspider.spring_boot_simple_crud_with_mysql.enity.Product;
import com.jspider.spring_boot_simple_crud_with_mysql.repository.ProductRepository;

@Repository
public class ProductDao {

	@Autowired
	ProductRepository productRepository;

	public Product saveProductDao(Product product) {

		return productRepository.save(product);

	}

	public List<Product> saveMultipalProductDao(List<Product> products) {

		return productRepository.saveAll(products);

	}

	public List<Product> findAllProductDao() {
		return productRepository.findAll();
	}

	public Product findProductById(Integer id) {

		Optional<Product> optional = productRepository.findById(id);

		return optional.isPresent() ? optional.get() : null;

	}

	public List<Product> findAllProductNameDao(String name) {

		return productRepository.findByName(name);
	}

	public List<Product> findAllProductColorDao(String color) {

		return productRepository.findByColor(color);
	}

	public List<Product> findAllProductByPriceDao(Double price) {

		return productRepository.findByPrice(price);
	}

	// by Native query
	public List<Product> getAllProductByPriceDao(double price) {

		return productRepository.getProductByPrice(price);
	}

	// Jpql query
	public List<Product> getAllProductByColorDao(String color) {

		return productRepository.getProductByColor(color);
	}

	public void deleteProductByPrice(double price) {

		productRepository.deleteProductByPrice(price);

	}

	public List<Product> getAllProductColorDao(String color) {

		return productRepository.getProductByColor(color);

	}
	
	
	public org.springframework.data.domain.Page<Product> getProductByPageNumberDao1(int initialPage, int pageSize) {
		
		 
		return productRepository.findAll(PageRequest.of(initialPage, pageSize));
		
		
		 
	}

	public Page<Product> getProductByPageNumberDao(int initialPage, int pageSize) {
 		
		
		return productRepository.findAll(PageRequest.of(initialPage, pageSize));
	}
	
	
	public List<Product> getAllProductBySortingIndescendingOrderDao(String Attribute) {
		return null;
 
		//return productRepository.findAll(Sort.by(Direction.Desc, Attribute))
		
		//return productRepository.findAll(Sort.by(Direction.FORWARD)));
		
 

		
 	}
	
	
	

}
