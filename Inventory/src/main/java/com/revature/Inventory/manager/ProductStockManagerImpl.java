package com.revature.Inventory.manager;

public class ProductStockManagerImpl implements ProductStockManager {
import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Inventory.dao.ProductStockDao;
import com.revature.Inventory.model.ProductStock;


@Service
public class ProductStockManagerImpl implements ProductStockManager{
	
	private ProductStockDao dao;
	
	@Override
	public List<ProductStock> findAll() {
		return StreamSupport.stream(dao.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
//	public List<Threshold> fetchProductProductStockInnerJoin(){
//		return null;
//	}


}
