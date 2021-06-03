package com.ardaatay.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ardaatay.northwind.business.abstracts.ProductService;
import com.ardaatay.northwind.core.utilities.results.DataResult;
import com.ardaatay.northwind.core.utilities.results.Result;
import com.ardaatay.northwind.entities.concretes.Product;
import com.ardaatay.northwind.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

	private ProductService productService;

	@Autowired
	public ProductsController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll() {
		return this.productService.getAll();
	}

	@GetMapping("/getallByPage")
	public DataResult<List<Product>> getAllByPage(@RequestParam int pageNo, @RequestParam int pageSize) {
		return this.productService.getAll(pageNo, pageSize);
	}

	@GetMapping("/getallByPageAndSort")
	public DataResult<List<Product>> getAllByPageAndSort(@RequestParam int pageNo, @RequestParam int pageSize,
			@RequestParam String sortColumn) {
		return this.productService.getAllSorted(pageNo, pageSize, sortColumn);
	}

	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}

	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName) {
		return this.productService.getByProductName(productName);
	}

	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam String productName,
			@RequestParam int categoryId) {
		return this.productService.getByProductNameAndCategoryId(productName, categoryId);
	}

	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
		return this.productService.getByProductNameContains(productName);
	}

	@GetMapping("/getByNameAndCategoryId")
	public DataResult<List<Product>> getByNameAndCategory(@RequestParam String productName,
			@RequestParam int categoryId) {
		return this.productService.getByNameAndCategoryId(productName, categoryId);
	}

	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return this.productService.getProductWithCategoryDetails();
	}
}
