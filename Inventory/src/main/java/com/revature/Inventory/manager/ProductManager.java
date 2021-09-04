package com.revature.Inventory.manager;


import com.revature.Inventory.model.Product;

import java.util.List;


public interface ProductManager {
	public Product create(Product p);
	List<Product> findAll();


}
