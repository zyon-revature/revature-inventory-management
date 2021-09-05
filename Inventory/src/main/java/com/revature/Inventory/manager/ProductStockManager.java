package com.revature.Inventory.manager;

import java.util.List;

import com.revature.Inventory.model.ProductStock;


public interface ProductStockManager {
	
	List<ProductStock> findAll();
	
	ProductStock findById(int id);
	
	ProductStock create(ProductStock ps);

}
