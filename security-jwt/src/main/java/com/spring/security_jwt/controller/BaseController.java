package com.spring.security_jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security_jwt.controller.service.UserService;
import com.spring.security_jwt.model.User;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class BaseController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("hello")
	public String hello(HttpServletRequest request) {
		return "hello " + request.getSession().getId();
	}
	
	@PostMapping("register")
	public User register(@RequestBody User user) {
		return userService.setValue(user);
	}
}
