package com.revature.Inventory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.Inventory.model.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{//Integer needs to be changed to String
	
	/*
	 * Or if String is not an option, method can be created that searches by id but should be written where
	 * it returns the category based by the id. This seems like a roundabout way to do it but better than nothing.
	 * 
	 * Based on Javadocs, String should be able to replace the Integer class argument in the generic
	 */
	
	@Query("select p from product p where p.category = ?1")
	public List<Product> getProductsByCategory(@Param("category")String category);
	
	@Query("select p from product p where p.id = ?1")
	public List<Product> getProductById(@Param("id")int id);
}
