package com.revature.Inventory.manager;

import java.util.List;


import com.revature.Inventory.model.Product;

public interface ProductManager {

	List<Product> findAllCategories();
	List<Product> findByCategory(String category);
	
	//List<Product> fetchProductByCategory();
	//List<GetCategory> getCategories();
	//List<Product> getProductsByCategory(String category);
 
}
