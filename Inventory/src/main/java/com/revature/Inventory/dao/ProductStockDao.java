package com.revature.Inventory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.Inventory.model.ProductStock;
import com.revature.Inventory.model.Threshold;






public interface ProductStockDao extends JpaRepository<ProductStock, Integer>{
	
	public List<ProductStock> findAll();
	
	@Query("SELECT ps FROM productstock ps")
	public List<ProductStock> findAllProductStocks();
	
	@Query("SELECT p.title AS title, (p.minlimit - ((SUM(CASE " +
				"WHEN ps.transactiontype LIKE 'IN' " +
				"THEN ps.quantity ELSE 0 END )) - SUM(CASE " +
				"WHEN ps.transactiontype LIKE 'OUT' " +
				"THEN ps.quantity ELSE 0 END ))) AS demand " +
			"FROM productstock ps INNER JOIN ps.product p " +
			"GROUP BY p.title, p.id, p.minlimit " +
			"HAVING (p.minlimit - ((SUM(CASE " +
				"WHEN ps.transactiontype LIKE 'IN' " +
				"THEN ps.quantity ELSE 0 END )) - SUM(CASE " +
				"WHEN ps.transactiontype LIKE 'OUT' " +
				"THEN ps.quantity ELSE 0 END ))) >= 0 " +
			"ORDER BY p.title ASC"
	)
	List<Threshold> findThreshold();


	@Query("SELECT p.title AS title, (p.minlimit - ps.quantity) AS demand FROM productstock ps INNER JOIN ps.product p WHERE p.minlimit > ps.quantity ORDER BY title ASC")
	List<Threshold> findAllThreshold();


	
	
	
}
