package com.taskapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String showIndexPage(Model model) {
		model.addAttribute("activePage", "home");
		return "index";
	}
	
	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("activePage", "login");
		return "views/loginForm";
	}
	
	
}
