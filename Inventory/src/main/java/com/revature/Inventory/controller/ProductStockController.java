package com.revature.Inventory.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Inventory.manager.ProductManager;
import com.revature.Inventory.manager.ProductStockManager;
import com.revature.Inventory.manager.ProductStockManagerImpl;
import com.revature.Inventory.model.Product;
import com.revature.Inventory.model.ProductStock;
import com.revature.Inventory.model.Threshold;

@RestController
@RequestMapping(path= "/productstocks")
public class ProductStockController {

	@Autowired
	private ProductStockManager manager;
	
	@Autowired
	private ProductManager productManager;
	
	@GetMapping(path="/invoices", produces = "application/json", consumes = "application/json")
	public List<ProductStock> getAllInvoices(){
		return ProductStockManager.findAll();
	}
	
	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public ProductStock create(@Valid @RequestBody ProductStock ps) {
		Product product = new Product();
		product = ProductManager.findById(ps.getProductId().getId());
		if(product == null) {
			product = productManager.create(ps.getProductId());
			ps.setProductId(product);
		}
		ps.setProductId(product);
		return ProductStockManager.create(ps);}
	
	@GetMapping(path = "/threshold" ,produces = "application/json")
	public List<Threshold> getDemand(){
		return manager.findThreshold();
	}
	
	@GetMapping(path = "/threshold/all" ,produces = "application/json")
	public List<Threshold> getAllDThreshold(){
		return manager.findAllThreshold();
	}
}
