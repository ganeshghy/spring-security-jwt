package com.spring.security_jwt.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.security_jwt.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	User findByUsername(String username);
}
