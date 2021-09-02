package com.revature.Inventory.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.revature.Inventory.manager.ProductStockManager;
import com.revature.Inventory.model.ProductStock;
import com.revature.Inventory.model.Threshold;



@RestController
@RequestMapping(path= "/productstocks")
public class ProductStockController {

	@Autowired()
	private ProductStockManager manager;
	
	
	@GetMapping(path = "/threshold" ,produces = "application/json")
	public List<Threshold> getDemand(){
		return manager.findThreshold();
	}
	
	@GetMapping(path = "/threshold/all" ,produces = "application/json")
	public List<Threshold> getAllDThreshold(){
		return manager.findAllThreshold();
	}
}
