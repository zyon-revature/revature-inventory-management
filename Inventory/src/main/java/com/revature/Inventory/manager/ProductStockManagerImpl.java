package com.revature.Inventory.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Inventory.dao.ProductStockDao;
import com.revature.Inventory.model.ProductStock;
import com.revature.Inventory.model.Threshold;


@Service
public class ProductStockManagerImpl implements ProductStockManager{
	
	@Autowired
	private ProductStockDao dao;

	@Override
	public List<Threshold> findAllDemand() {
		return dao.findAllDemand();
	}
	
	@Override
	public List<Threshold> findDemand() {
		return dao.findDemand();
	}
	
	


}
