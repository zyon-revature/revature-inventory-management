package com.revature.Inventory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.Inventory.model.Product;


public interface ProductDao extends JpaRepository<Product, Integer>{
	@Query("select p from product p")
	public List<Product> findAll();
	
}
