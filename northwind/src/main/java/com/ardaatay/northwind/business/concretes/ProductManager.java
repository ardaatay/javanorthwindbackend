package com.ardaatay.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ardaatay.northwind.business.abstracts.ProductService;
import com.ardaatay.northwind.core.utilities.pagination.Pagination;
import com.ardaatay.northwind.core.utilities.results.DataResult;
import com.ardaatay.northwind.core.utilities.results.Result;
import com.ardaatay.northwind.core.utilities.results.SuccessDataResult;
import com.ardaatay.northwind.core.utilities.results.SuccessResult;
import com.ardaatay.northwind.dataAccess.abstracts.ProductDao;
import com.ardaatay.northwind.entities.concretes.Product;
import com.ardaatay.northwind.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager implements ProductService {

	private ProductDao productDao;

	@Autowired
	public ProductManager(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		Sort sort = Sort.by(Sort.Direction.ASC, "productName");
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort), "Data listelendi.");
	}

	@Override
	public DataResult<Pagination<List<Product>>> getAll(int pageNo, int pageSize) {
		Sort sort = Sort.by(Sort.Direction.ASC, "productName");

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);

		Pagination<List<Product>> pagination = new Pagination<List<Product>>();
		pagination.setItems(this.productDao.findAll(pageable).getContent());
		pagination.setTotalCount(this.productDao.count());

		return new SuccessDataResult<Pagination<List<Product>>>(pagination);
	}

	@Override
	public DataResult<List<Product>> getAllSorted(int pageNo, int pageSize, String sortColumn) {
		Sort sort = Sort.by(Sort.Direction.ASC, sortColumn);

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);

		return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("??r??n eklendi");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>(this.productDao.getByProductName(productName), "Data listelendi.");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<Product>(
				this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId), "Data listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(
				this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId), "Data listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByCategory_CategoryIdIn(categories),
				"Data listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName),
				"Data listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName),
				"Data listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName, categoryId),
				"Data listelendi.");
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails(),
				"Data Listelendi.");
	}
}
