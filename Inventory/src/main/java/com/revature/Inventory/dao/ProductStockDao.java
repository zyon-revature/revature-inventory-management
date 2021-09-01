package com.revature.Inventory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.Inventory.model.ProductStock;



public interface ProductStockDao extends JpaRepository<ProductStock, Integer>{

	public List<ProductStock> findAll();
	
//	@Query("SELECT p.title, (ps.quantity - p.minlimit) AS demand FROM inventory.product p INNER JOIN inventory.productStock ps ON p.id = ps.id where p.minlimit > ps.quantity")
//	public List<ThresholdLevel> fetchProductJoinProductStockWhereLessThanThreshold();
	
//	@Query("SELECT new com.revature.Inventory.model.Threshold(p.title, (ps.quantity - p.minlimit)) " 
//			+ "FROM productstock ps INNER JOIN ps.products p")
//	List<Threshold> fetchProductProductStockInnerJoin();
	
	
}
