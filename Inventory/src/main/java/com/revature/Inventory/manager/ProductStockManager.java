package com.revature.Inventory.manager;

import java.util.List;

<<<<<<< Updated upstream
import javax.validation.Valid;

import com.revature.Inventory.model.ProductStock;
import com.revature.Inventory.model.Threshold;

public interface ProductStockManager {
	
    List<ProductStock> findAll();
	
    ProductStock findById(int id);
	
    ProductStock create(ProductStock ps);

    ProductStock update(@Valid ProductStock ps);
=======

import com.revature.Inventory.model.ProductStock;

>>>>>>> Stashed changes

public interface ProductStockManager {
	
	List<ProductStock> findAll();
	
	ProductStock findById(int id);
	
	ProductStock create(ProductStock ps);

}
