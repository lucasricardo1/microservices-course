package com.lucasricardo.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasricardo.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
}
