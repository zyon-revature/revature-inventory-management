package com.revature.Inventory.manager;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Inventory.dao.ProductDao;
import com.revature.Inventory.model.Product;

@Service
@Transactional
public class ProductManagerImpl implements ProductManager {

	@Autowired
	private ProductDao dao;

	@Override
	public Product create(Product p) {

		return dao.save(p);
	}

}
