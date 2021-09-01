package com.revature.Inventory.controller;


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
	private ProductManager manager;

	@PostMapping(consumes = "application/json", produces = "application/json")
	public Product create(@Valid @RequestBody Product p) {
		return manager.create(p);
	}

	@GetMapping(produces = "application/json")
	public List<Product> getAllProducts() {
		return manager.findAll();

	}
}
