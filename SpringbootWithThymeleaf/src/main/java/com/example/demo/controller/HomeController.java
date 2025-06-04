package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("message", "Hello, Sudhir!");
		return "home";
	}

	@GetMapping("/wel")
	public String home1(Model model) {
		model.addAttribute("message", "Hello, Rakesh!");
		return "NewFile";
	}

	@GetMapping("/openProfile")
	public String openProFilePage(Model model) {

		String name = "Sudhir Kumar";
		model.addAttribute("modelName", name);
		return "profile";

	}

	@GetMapping("/openConditionalPage")
	public String openConditionalPage(Model model) {
		int no1 = 10;
		int no2 = 20;

		model.addAttribute("no1", no1);
		model.addAttribute("no2", no2);

		return "conditional2";

	}
	
	@GetMapping("/openLoopingPage")
	public String openLoopingPage(Model model) {
		 
		List<Integer> numbers = List.of(1,2,3,4,5,6,7);
		
		model.addAttribute("modelNumbers", numbers);
 
		return "looping";

	}

}