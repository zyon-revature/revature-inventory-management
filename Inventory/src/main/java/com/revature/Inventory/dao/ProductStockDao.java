package com.revature.Inventory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.Inventory.model.ProductStock;
import com.revature.Inventory.model.Threshold;



public interface ProductStockDao extends JpaRepository<ProductStock, Integer>{

	public List<ProductStock> findAll();
	
// SQL Query
// SELECT p.title, (ps.quantity - p.minlimit) AS demand FROM inventory.product p INNER JOIN inventory.productStock ps ON p.id = ps.id where p.minlimit > ps.quantity;

	
	@Query("SELECT p.title AS title, (ps.quantity - p.minlimit) AS demand FROM productstock ps INNER JOIN ps.product p")
	List<Threshold> findAllDemand();
	
	@Query("SELECT p.title AS title, (p.minlimit - ps.quantity) AS demand FROM productstock ps INNER JOIN ps.product p WHERE p.minlimit > ps.quantity")
	List<Threshold> findDemand();
	
	
	
}
