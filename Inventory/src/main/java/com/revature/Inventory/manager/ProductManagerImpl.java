package com.revature.Inventory.manager;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Inventory.dao.ProductDao;
import com.revature.Inventory.model.GetCategory;
import com.revature.Inventory.model.Product;

@Service
public class ProductManagerImpl implements ProductManager{

	@Autowired
	private ProductDao dao;
	
	@Override
	public List<Product> findAllProducts() {
		
		return StreamSupport.stream(dao.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}

	/*@Override
	public List<Object[]> findProductByCategory() {
		
		return dao.getCategory();
	}*/

	@Override
	public List<Product> findProductCategoryById() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*this will most likely be deleted later
	 * @Override
	public List<Product> findAllProductsByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}*/


	@Override
	public List<Product> findAllProductsByCategory(String category) {
		
		return dao.getProductsByCategory(category);
	}

	@Override
	public List<GetCategory> fetchProductByCategory() {
		// TODO Auto-generated method stub
		return dao.fetchProductByCategory();
	}
}
