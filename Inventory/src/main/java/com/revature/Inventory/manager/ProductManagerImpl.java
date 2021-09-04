package com.revature.Inventory.manager;


import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
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

	@Override
	public List<Product> findAll() {
		return StreamSupport.stream(dao.findAll().spliterator(), false)
				.collect(Collectors.toList());

	}

}
