package com.revature.Inventory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.Inventory.model.ProductStock;

import jdk.jfr.Threshold;




public interface ProductStockDao extends JpaRepository<ProductStock, Integer>{
	
	public List<ProductStock> findAll();
	
	@Query("SELECT ps FROM productstock ps")
	public List<ProductStock> findAllProductStocks();
	
	@Query("SELECT p.title AS title, (p.minlimit - ps.quantity) AS demand FROM productstock ps INNER JOIN ps.product p")
	List<Threshold> findAllDemand();
	
	@Query("SELECT p.title AS title, (p.minlimit - ps.quantity) AS demand FROM productstock ps INNER JOIN ps.product p WHERE p.minlimit > ps.quantity")
	List<Threshold> findDemand();
	
	
	
}
