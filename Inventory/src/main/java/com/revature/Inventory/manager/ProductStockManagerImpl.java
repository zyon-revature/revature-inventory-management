package com.revature.Inventory.manager;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.Inventory.dao.ProductStockDao;
import com.revature.Inventory.model.ProductStock;

import java.util.stream.Collectors;

@Service
@Transactional
public class ProductStockManagerImpl implements ProductStockManager{
	
	@Autowired
	private ProductStockDao dao;
	
	@Override
	public List<ProductStock> findAll() {
		return StreamSupport.stream(dao.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public ProductStock findById(int id) {
		return dao.findById(Integer.valueOf(id)).get();
	}

	@Override
	public ProductStock create(ProductStock ps) {
		return dao.save(ps);
	}
	

	@Override
	public List<Threshold> findAllThreshold() {
		return dao.findAllThreshold();
	}
	
	@Override
	public List<Threshold> findThreshold() {
		return dao.findThreshold();
	}
	
	


}
