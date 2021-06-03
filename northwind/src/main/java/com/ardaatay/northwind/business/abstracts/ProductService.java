package com.ardaatay.northwind.business.abstracts;

import java.util.List;

import com.ardaatay.northwind.core.utilities.results.DataResult;
import com.ardaatay.northwind.core.utilities.results.Result;
import com.ardaatay.northwind.entities.concretes.Product;
import com.ardaatay.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	DataResult<List<Product>> getAll();

	DataResult<List<Product>> getAll(int pageNo, int pageSize);

	DataResult<List<Product>> getAllSorted(int pageNo, int pageSize, String sortColumn);

	Result add(Product product);

	DataResult<Product> getByProductName(String productName);

	DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);

	DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

	DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);

	DataResult<List<Product>> getByProductNameContains(String productName);

	DataResult<List<Product>> getByProductNameStartsWith(String productName);

	DataResult<List<Product>> getByNameAndCategoryId(String productName, int categoryId);
	
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();

}
