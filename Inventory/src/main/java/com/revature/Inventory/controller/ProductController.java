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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Inventory.manager.ProductManager;
import com.revature.Inventory.model.Product;

@RestController
@RequestMapping(path="/products")
public class ProductController {
	
	@Autowired
	private ProductManager manager;
	
	//test
	@GetMapping(produces = "application/json")
	public List<Product> getAllCatgories(){
		return manager.findAllCategories();
	}
	 
	@GetMapping(path="/{category}",produces="application/json")
	public List<Product> getCategories(@PathVariable String category) {
		System.out.println(category);
		return manager.findByCategory(category);
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
	
	
	
	/*@GetMapping(path="/{category}", produces="application/json")
	public List<Product> getProductsByCategory(@PathVariable String category){
		
		return manager.getProductsByCategory(category);
	}
	
	//query method. Delete this method if new method works which it should
	/*@GetMapping(path ="/{category}",produces = "application/json")//need to place the path id, either "/{category}" or "/category"
	public List<Product> getAllProductsByCategoryInput(@PathVariable String category){
		return manager.findAllProductsByCategory(category);
	}*/
	
	/*//categories
	@GetMapping(path="/categories", produces="application/json")
	public List<Product> getAllProductsByCategory(){
		return manager.fetchProductByCategory();
	}*/

}
