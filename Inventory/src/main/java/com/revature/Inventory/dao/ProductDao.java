package com.revature.Inventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.Inventory.model.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{
	
}
