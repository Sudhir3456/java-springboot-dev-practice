package com.example.demo.services;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;

@Repository
public interface UserService {

	
	public boolean registerUser(User user);
	
}
