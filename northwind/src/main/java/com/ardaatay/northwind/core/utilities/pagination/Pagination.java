package com.ardaatay.northwind.core.utilities.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagination<T> {
	private T items;
	private long totalCount;	
}
