package com.revature.Inventory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.Inventory.model.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

	List<Product> findByCategory(String category);
	/*@Query("select category from product p")
	public List<Product> fetchProductByCategory();
	
	@Query("select category from product p")
	List<GetCategory> getCategories();
	
	@Query("select p.category from product p where p.category = :category")
	List<Product> getProductsByCategory(@Param("category") String category);
	*/
	


}
