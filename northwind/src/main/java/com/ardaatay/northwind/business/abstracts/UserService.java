package com.ardaatay.northwind.business.abstracts;

import com.ardaatay.northwind.core.entities.User;
import com.ardaatay.northwind.core.utilities.results.DataResult;
import com.ardaatay.northwind.core.utilities.results.Result;

public interface UserService {
	Result add(User user);

	DataResult<User> getByEmail(String email);
}
