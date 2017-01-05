package com.webstore.services;

import org.springframework.data.repository.CrudRepository;

import com.webstore.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);

}
