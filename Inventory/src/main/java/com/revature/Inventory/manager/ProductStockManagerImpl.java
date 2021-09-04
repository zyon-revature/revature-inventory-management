package com.revature.Inventory.manager;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.Inventory.dao.ProductStockDao;
import com.revature.Inventory.model.ProductStock;
import com.revature.Inventory.model.Threshold;


@Service
public class ProductStockManagerImpl implements ProductStockManager{
	
	@Autowired
	private ProductStockDao dao;
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.NEVER)
	public List<ProductStock> findAll() {
		return StreamSupport.stream(dao.findAll().spliterator(), false).collect(Collectors.toList());
	}
	
	@Override
	public ProductStock findById(int id) {
		return dao.findById(Integer.valueOf(id)).get();
	}
	
	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = {
							   ConstraintViolationException.class }, propagation = Propagation.REQUIRES_NEW)  
	public ProductStock create(ProductStock ps) {
		return dao.save(ps);
	}

	@Override
	public ProductStock update(@Valid ProductStock ps) {
		// TODO Auto-generated method stub
		return null;
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
