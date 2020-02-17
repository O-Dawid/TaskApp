package com.taskapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.taskapp.entities.Role;
import com.taskapp.entities.User;
import com.taskapp.repositories.UserRepository;

@Service
public class UserService {

	// @Autowired
	UserRepository userRepository;

	UserService(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	
	public void createUser(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole = new Role("USER");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRole(roles);
		userRepository.save(user);
	}
	
	public void createAdmin(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole = new Role("ADMIN");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRole(roles);
		userRepository.save(user);
	}
	
	public User findOne(String email) {
		return userRepository.findById(email).orElse(null);
	}
	
	public int list () {
		return (int) userRepository.count();
	}

	public boolean isUserPresent(String email) {

		User u=findOne(email);
		if (u!=null) {
			return true;
		}
		return false;
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public List<User> findByName(String name) {
		// TODO Auto-generated method stub
		return userRepository.findByNameStartingWith(name);
	}
	
}
