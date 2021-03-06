package com.revature.Inventory.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import com.revature.Inventory.model.Threshold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Inventory.manager.ProductStockManager;
import com.revature.Inventory.model.ProductStock;




@RestController
@RequestMapping(path= "/productstocks")
public class ProductStockController {

	@Autowired
	private ProductStockManager manager;
	

	
	@GetMapping(path="/stocks", produces = "application/json", consumes = "application/json")
	public List<ProductStock> getAllStocks(){
		return manager.findAll();
	}
	
	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public ProductStock create(@RequestBody ProductStock ps) {
		return manager.create(ps);
	}

	@GetMapping(path = "/threshold" ,produces = "application/json")
	public List<Threshold> findThreshold(){
		return manager.findThreshold();
	}

	@GetMapping(path = "/threshold/all" ,produces = "application/json")
	public List<Threshold> findAllThreshold(){
		return manager.findAllThreshold();
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

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> handleConstraintViolationExceptions(ConstraintViolationException ex) {
		Map<String, String> errors = new HashMap<>();
		errors.put("message", ex.getCause().getLocalizedMessage());
		return errors;
	}
	 
}
