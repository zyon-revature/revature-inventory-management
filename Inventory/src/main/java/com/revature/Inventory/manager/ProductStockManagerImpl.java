package com.revature.Inventory.manager;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.Inventory.dao.ProductDao;
import com.revature.Inventory.dao.ProductStockDao;
import com.revature.Inventory.model.Product;
import com.revature.Inventory.model.ProductStock;
import com.revature.Inventory.model.Threshold;

import java.util.stream.Collectors;

@Service
@Transactional
public class ProductStockManagerImpl implements ProductStockManager{
	
	@Autowired
	private ProductStockDao dao;
	@Autowired
	private ProductDao daoP;
	
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
		Product product =daoP.findById(ps.getProductid()).get();
		ps.setProduct(product);
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
