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
public class ProductManagerImpl implements ProductManager{

	@Autowired
	private ProductDao dao;
	
	@Override
	public List<Product> findAllCategories() {
		
		return StreamSupport.stream(dao.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<Product> findByCategory(String category) {

		return dao.findByCategory(category);
	}

}
