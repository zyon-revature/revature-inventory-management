package com.revature.Inventory.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Inventory.manager.ProductManager;
import com.revature.Inventory.model.GetCategory;
import com.revature.Inventory.model.Product;

@RestController
@RequestMapping(path="/products")
public class ProductController {
	
	@Autowired
	private ProductManager manager;
	
	//test
	@GetMapping(path ="/category", produces = "application/json")
	public List<Product> getAllProducts(){
		return manager.findAllProducts();
	}
	
	
	//test asap
	@GetMapping(path="/test",produces="application/json")
	public List<Product> getProductCategoriesById(){//rename if works
		return manager.findProductCategoryById();//will update soon. need to make method in Manager portions 
	}
	
	
	//actual url path for categories
	@GetMapping(path="/categories", produces="application/json")
	public List<Product> getAllProductsByCategory(String category){
		return manager.findAllProductsByCategory(category);
	}
	 
	@GetMapping(path="categoryid",produces="application/json")
	public List<GetCategory> getCategories(){
		
		return manager.fetchProductByCategory();
	}

	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
	
	//query method. Delete this method if new method works which it should
	/*@GetMapping(path ="/{category}",produces = "application/json")//need to place the path id, either "/{category}" or "/category"
	public List<Product> getAllProductsByCategoryInput(@PathVariable String category){
		return manager.findAllProductsByCategory(category);
	}*/

}
