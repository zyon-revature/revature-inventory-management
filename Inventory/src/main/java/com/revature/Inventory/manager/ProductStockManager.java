package com.revature.Inventory.manager;

import java.util.List;

import com.revature.Inventory.model.ProductStock;
import com.revature.Inventory.model.Threshold;

public interface ProductStockManager {

	List<ProductStock> findAll();
	
	
	List<Threshold> findAllDemand();
	
	List<Threshold> findDemand();
}
