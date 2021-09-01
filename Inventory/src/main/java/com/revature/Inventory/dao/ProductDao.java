package com.revature.Inventory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.Inventory.model.GetCategory;
import com.revature.Inventory.model.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{//Integer needs to be changed to String
	
//	@Query("select category from product p")
//	public List<Object[]> getCategory();
	
	@Query("select p from product p where p.id = ?1")
	public List<Product> getProductById(@Param("id")int id);
	
	@Query("select p.category from product p")
	public List<GetCategory> fetchProductByCategory();
	/*
	 * Or if String is not an option, method can be created that searches by id but should be written where
	 * it returns the category based by the id. This seems like a roundabout way to do it but better than nothing.
	 * 
	 * Based on Javadocs, String should be able to replace the Integer class argument in the generic
	 * 
	 * select category from inventory.product p where p.id =1----this would be useful query based on id.
	 * the above does show the category 
	 * so the above should be written as "select category from product p where p.id =?1". this should work.
	 * since it wants id, the String in the generic argument should be Integer again. 
	 */
	
	
	//this method will not be needed most likely, get rid of if the case
	@Query("select category from product p")
	public List<Product> getProductsByCategory(String category);
	
	
}
