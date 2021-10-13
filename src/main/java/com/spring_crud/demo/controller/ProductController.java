package com.spring_crud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Http2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_crud.demo.model.Product;
import com.spring_crud.demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable long id) {
		return new ResponseEntity<Product>(productService.getProduct(id), HttpStatus.OK);

	}

	@GetMapping(value = "/")
	public ResponseEntity<List<Product>> getAllProduct() {
		return new ResponseEntity<List<Product>>(productService.getAllProduct(), HttpStatus.OK);
	}

	@PostMapping(value = "/")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable long id) {
		return new ResponseEntity<Product>(productService.updateProduct(product, id), HttpStatus.CREATED);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable long id){
		productService.deleteProduct(id);
		return new ResponseEntity<String>("Delete Successfully",HttpStatus.OK);
	}
	
}
