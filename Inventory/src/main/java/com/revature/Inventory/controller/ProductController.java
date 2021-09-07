package com.revature.Inventory.controller;


import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Inventory.manager.ProductManager;
import com.revature.Inventory.model.Product;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
	
	@Autowired
	private ProductManager manager1;
	
	@GetMapping(path="/category", produces = "application/json")
	public List<Product> getAllCatgories(){
		return manager1.findAllCategories();
	}
	 
	@GetMapping(path="/{category}",produces="application/json")
	public List<Product> getCategories(@PathVariable String category) {
		System.out.println(category);
		return manager1.findByCategory(category);
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public Product create(@Valid @RequestBody Product p) {
		return manager1.create(p);
	}

	@GetMapping(produces = "application/json")
	public List<Product> getAllProducts() {
		return manager1.findAll();

	}
}
