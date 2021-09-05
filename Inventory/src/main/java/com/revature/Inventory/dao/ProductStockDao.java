package com.revature.Inventory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.Inventory.model.ProductStock;







public interface ProductStockDao extends JpaRepository<ProductStock, Integer>{
	
	@Query("select ps from productstock ps where ps.id = :productId")
	public ProductStock findById(@Param("productId") int id);

	public List<ProductStock> findAll();
	
	@Query("SELECT ps FROM productstock ps")
	public List<ProductStock> findAllProductStocks();
	
	
	
}
