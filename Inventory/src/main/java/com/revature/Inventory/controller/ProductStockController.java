package com.revature.Inventory.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import javax.validation.Valid;

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

<<<<<<< Updated upstream
import com.revature.Inventory.manager.ProductManager;
=======
>>>>>>> Stashed changes
import com.revature.Inventory.manager.ProductStockManager;
import com.revature.Inventory.manager.ProductStockManagerImpl;
import com.revature.Inventory.model.Product;
import com.revature.Inventory.model.ProductStock;
<<<<<<< Updated upstream
import com.revature.Inventory.model.Threshold;
=======

>>>>>>> Stashed changes

@RestController
@RequestMapping(path= "/productstocks")
public class ProductStockController {
<<<<<<< Updated upstream

	@Autowired
	private ProductStockManager manager;
	
	@Autowired
	private ProductManager productManager;
	
	@GetMapping(path="/invoices", produces = "application/json", consumes = "application/json")
	public List<ProductStock> getAllInvoices(){
		return ProductStockManager.findAll();
	}
	
	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public ProductStock create(@Valid @RequestBody ProductStock ps) {
		Product product = new Product();
		product = ProductManager.findById(ps.getProductId().getId());
		if(product == null) {
			product = productManager.create(ps.getProductId());
			ps.setProductId(product);
		}
		ps.setProductId(product);
		return ProductStockManager.create(ps);}
=======
	
	@Autowired
	private ProductStockManager manager;
	
	@GetMapping(produces = "application/json")
	public List<ProductStock> getAllStocks(){
		return manager.findAll();
	}
>>>>>>> Stashed changes
	
	@PostMapping(path = "/create/{id}", consumes = "application/json", produces = "application/json")
	public ProductStock create(@RequestBody ProductStock ps) {
		return manager.create(ps);
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
