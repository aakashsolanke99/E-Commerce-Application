package com.aakash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aakash.entity.User;
import com.aakash.service.UserService;

import jakarta.annotation.PostConstruct;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostConstruct    // when we build a application this method will execute
	public void initRoleAndUser() {
		userService.initRoleAndUser();
	}
	
	@PostMapping("/registerNewUser")
	public User registerNewUser(@RequestBody User user) {
		return userService.registerNewUser(user);
	}

	@GetMapping("/forAdmin")
	public String forAdmin() {
		return "This URL is only accessible to admin";
	}
	
	@GetMapping("/forUser")
	public String forUser() {
		return "This URL is only accessible to User";
	}
}
