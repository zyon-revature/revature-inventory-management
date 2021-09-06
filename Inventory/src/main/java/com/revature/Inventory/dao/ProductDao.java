package com.revature.Inventory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.Inventory.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{

	List<Product> findByCategory(String category);

}
