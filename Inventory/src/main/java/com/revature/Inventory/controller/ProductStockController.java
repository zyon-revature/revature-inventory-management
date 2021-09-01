package com.revature.Inventory.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.revature.Inventory.manager.ProductStockManager;
import com.revature.Inventory.model.ProductStock;



@RestController
@RequestMapping(path= "/stocks")
public class ProductStockController {

	@Autowired()
	private ProductStockManager manager;
	
	@GetMapping(produces = "application/json")
	public List<ProductStock> getAllProductStocks(){
		return manager.findAll();
	}
}
