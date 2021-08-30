package com.revature.Inventory.manager;

import java.util.List;

import com.revature.Inventory.model.Product;

public interface ProductManager {

	List<Product> findAllProducts();
	List<Product> findAllProductsByCategory(String category);
}
