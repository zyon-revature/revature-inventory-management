package com.revature.Inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Inventory.manager.ProductManager;
import com.revature.Inventory.model.Product;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

	@Autowired
	private ProductManager manager;
	
	@GetMapping(produces = "application/json")
	public List<Product> getAllProducts(){
		return manager.findAll();
	}
}
