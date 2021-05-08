package com.ardaatay.northwind.business.abstracts;

import java.util.List;

import com.ardaatay.northwind.entities.concretes.Product;

public interface ProductService {
	List<Product> getAll();
}
