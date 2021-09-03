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
@RequestMapping(path="/categories")
public class ProductController {
	
	@Autowired
	private ProductManager manager;
	
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

}
