package com.spring.security_jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security_jwt.model.User;
import com.spring.security_jwt.service.JwtService;
import com.spring.security_jwt.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class BaseController {
	
	@Autowired
	private UserService userService;
	
	@Autowired(required=true)
	AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;
	
	@GetMapping("hello")
	public String hello(HttpServletRequest request) {
		return "hello " + request.getSession().getId();
	}
	
	@PostMapping("register")
	public User register(@RequestBody User user) {
		return userService.setValue(user);
	}
	
	@PostMapping("login")
	public String login(@RequestBody User user) {
		Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(user.getUsername());
		}else {
			return "fail";
		}
	}
}
