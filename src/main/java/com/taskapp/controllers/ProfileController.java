package com.taskapp.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taskapp.entities.Task;
import com.taskapp.entities.User;
import com.taskapp.services.TaskService;
import com.taskapp.services.UserService;



@Controller
public class ProfileController {

	@Autowired
	TaskService taskService;
	@Autowired
	UserService userService;
	
	@GetMapping("/profile")
	public String showProfilePage(Model model, Principal principal, @RequestParam(defaultValue = "") String description) {
		
		model.addAttribute("activePage", "profile");
		
		String email = principal.getName();
		User user = userService.findOne(email);
		
		List<Task>tasks =  taskService.findUserTask(user);
		List<Task>tasksDecs = taskService.findByDescription(description); 
		List<Task>tasksDecsanduser = taskService.findByDescriptionAndUser(description, user); 
		
		model.addAttribute("tasks", tasksDecsanduser);
		
		return "views/profile";
	}
	
}
