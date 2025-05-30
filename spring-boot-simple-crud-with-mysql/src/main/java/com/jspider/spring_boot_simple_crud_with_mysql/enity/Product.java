package com.jspider.spring_boot_simple_crud_with_mysql.enity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data  after configuare sts toll with lombok


@Schema(name = "This is entity Class")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	private int id;
	private String name;
	private String color;
	private double price;

}
