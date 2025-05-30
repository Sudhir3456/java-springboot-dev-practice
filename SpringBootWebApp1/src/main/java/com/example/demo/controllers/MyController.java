package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@Controller
public class MyController {
	
	@Autowired
	private UserService service;
	
	
	@GetMapping("/regPage")
	public String openRegePage(Model model) {
		
		model.addAttribute("user", new User());
		return "register";
	}

	
	@PostMapping("/regForm")
	public String sumitRegisterForm(@ModelAttribute("user") User user, Model model) {
		
		boolean registerUser = service.registerUser(user);
		
		if (registerUser) {
			
			model.addAttribute("successMsg", "User registered successfully");
		} else {
			model.addAttribute("errorMsg", "User not registeredb due to some error");

		}
		return "register";
	}

}
