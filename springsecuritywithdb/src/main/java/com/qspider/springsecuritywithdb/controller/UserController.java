package com.qspider.springsecuritywithdb.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qspider.springsecuritywithdb.entity.User;
import com.qspider.springsecuritywithdb.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // ✅ API 1: Register
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        userRepository.save(user);
        return "User Registered Successfully!";
    }

    // ✅ API 2: Welcome after login
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome! You are authenticated.";
    }
}