package com.revature.Inventory.manager;

import java.util.List;

import com.revature.Inventory.model.GetCategory;
import com.revature.Inventory.model.Product;

public interface ProductManager {

	List<Product> findAllProducts();
	List<Product> findProductCategoryById();
	List<GetCategory> fetchProductByCategory();
	
 	List<Product> findAllProductsByCategory(String category);
}
