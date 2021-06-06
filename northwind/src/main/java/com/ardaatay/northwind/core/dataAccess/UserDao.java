package com.ardaatay.northwind.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ardaatay.northwind.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User getByEmail(String email);
}
